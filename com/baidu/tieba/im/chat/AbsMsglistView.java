package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AbsMsglistView extends com.baidu.adp.base.c<MsglistActivity<?>> implements com.baidu.adp.lib.voice.f {
    protected com.baidu.tbadk.editortools.b mActionListener;
    protected h mAdapter;
    private ImageView mBackImage;
    protected View mBtnGroupInfo;
    private a mCallback;
    protected MsglistActivity mContext;
    private final Handler mHandler;
    private View mImgBack;
    protected FrameLayout mInputControl;
    protected ViewGroup mLayBottom;
    private LinearLayout mLayNewMsg;
    private BdTypeListView mLisMsg;
    protected FrameLayout mListMain;
    private VoiceData.VoiceModel mModel;
    protected com.baidu.tbadk.core.dialog.i mMsgItemOperation;
    protected NavigationBar mNavigationBar;
    protected boolean mNeedShowName;
    private NoNetworkView mNetworkView;
    private ImageView mNotNotify;
    private ProgressBar mPrgLisMsg;
    private ImageView mReceiver;
    private final com.baidu.tbadk.core.dialog.a mResendDialog;
    protected KeyboardLayout mRootView;
    protected m mSendTool;
    protected ISendVoiceView mSendVoiceView;
    private TextView mTexGroup;
    private String mTextContent;
    private TextView mTextNewMsg;
    protected EditorTools mTool;
    private View personal_lbs_shadow;
    private TextView personal_lbs_title_lbsinfo;
    private TextView personal_lbs_title_name;
    private TextView personal_lbs_title_time;
    private View personalchat_lbs_title;

    /* loaded from: classes.dex */
    public interface a {
        void cTc();

        void e(VoiceData.VoiceModel voiceModel);
    }

    protected abstract boolean isPersonal();

    protected abstract void setNeedShowName();

    public AbsMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity.getPageContext());
        this.mNavigationBar = null;
        this.mImgBack = null;
        this.mTexGroup = null;
        this.mBtnGroupInfo = null;
        this.personalchat_lbs_title = null;
        this.personal_lbs_title_name = null;
        this.personal_lbs_title_lbsinfo = null;
        this.personal_lbs_shadow = null;
        this.personal_lbs_title_time = null;
        this.mReceiver = null;
        this.mNotNotify = null;
        this.mNetworkView = null;
        this.mLisMsg = null;
        this.mPrgLisMsg = null;
        this.mTool = null;
        this.mTextContent = null;
        this.mActionListener = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar != null) {
                    if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof u)) {
                            u uVar = (u) aVar.data;
                            EmotionGroupType bxC = uVar.bxC();
                            String name = uVar.getName();
                            if (bxC != EmotionGroupType.LOCAL && name != null) {
                                AbsMsglistView.this.mContext.d(uVar);
                                AbsMsglistView.this.onSendEmotion();
                            }
                        }
                    } else if (aVar.code == 8) {
                        AbsMsglistView.this.mContext.cTQ();
                    } else if (aVar.code == 4) {
                        if (aVar.data != null && (aVar.data instanceof String)) {
                            AbsMsglistView.this.mTextContent = (String) aVar.data;
                        }
                    } else if (aVar.code == 14) {
                        AbsMsglistView.this.mContext.cTR();
                    }
                }
            }
        };
        this.mSendTool = null;
        this.mSendVoiceView = null;
        this.mLayNewMsg = null;
        this.mTextNewMsg = null;
        this.mContext = null;
        this.mMsgItemOperation = null;
        this.mResendDialog = null;
        this.mLayBottom = null;
        this.mHandler = new Handler() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        AbsMsglistView.this.mHandler.removeMessages(1);
                        AbsMsglistView.this.closeRecordCancel();
                        AbsMsglistView.this.closeRecordTooShort();
                        return;
                    default:
                        return;
                }
            }
        };
        this.mNeedShowName = true;
        this.mRootView = null;
        this.mContext = msglistActivity;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        this.mRootView = (KeyboardLayout) msglistActivity.findViewById(R.id.msg_root_view);
        initHeader(msglistActivity, z);
        initNoNetwork(msglistActivity);
        initMsglist(msglistActivity);
        initMsgSend(msglistActivity);
        initNewMsg(msglistActivity);
        initBottom(msglistActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mBackImage = this.mNavigationBar.getBackImageView();
        this.mTexGroup = this.mNavigationBar.setCenterTextTitle("");
        this.mNotNotify = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.msg_chat_top_notify, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(R.id.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mBackImage = this.mNavigationBar.getBackImageView();
        this.personalchat_lbs_title = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.personal_chat_lbs_title, (ViewGroup) null);
        this.personal_lbs_title_name = (TextView) this.personalchat_lbs_title.findViewById(R.id.personal_lbs_title_name);
        this.personal_lbs_title_lbsinfo = (TextView) this.personalchat_lbs_title.findViewById(R.id.personal_lbs_title_lbsinfo);
        this.personal_lbs_title_time = (TextView) this.personalchat_lbs_title.findViewById(R.id.personal_lbs_title_time);
        this.mNotNotify = (ImageView) this.personalchat_lbs_title.findViewById(R.id.img_close_notify);
        this.personal_lbs_shadow = this.personalchat_lbs_title.findViewById(R.id.personal_lbs_shadow);
        this.mNavigationBar.setTitleView(this.personalchat_lbs_title, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(R.id.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    private void initNoNetwork(TalkableActivity talkableActivity) {
        this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(R.id.view_no_network);
    }

    public h getAdapter() {
        return this.mAdapter;
    }

    public void MainOnTouch() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initMsglist(final MsglistActivity msglistActivity) {
        this.mListMain = (FrameLayout) msglistActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(R.id.lis_msg);
        this.mPrgLisMsg = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.mPrgLisMsg.setVisibility(8);
        this.mAdapter = new h(msglistActivity.getPageContext(), this.mLisMsg);
        setNeedShowName();
        this.mAdapter.sb(this.mNeedShowName);
        this.mAdapter.sc(isPersonal());
        this.mAdapter.a(msglistActivity);
        this.mAdapter.setOnItemViewLongClickListener(msglistActivity);
        this.mLisMsg.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                l.hideSoftKeyPad(msglistActivity.getActivity(), msglistActivity.getActivity().getCurrentFocus());
                if (AbsMsglistView.this.mTool != null) {
                    AbsMsglistView.this.mTool.bAK();
                }
            }
        });
        this.mLisMsg.setOnSrollToTopListener(msglistActivity);
        this.mLisMsg.setOnSrollToBottomListener(msglistActivity);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        this.mLisMsg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                l.hideSoftKeyPad(msglistActivity.getActivity(), msglistActivity.getActivity().getCurrentFocus());
                if (AbsMsglistView.this.mTool != null) {
                    AbsMsglistView.this.mTool.bAK();
                }
                AbsMsglistView.this.MainOnTouch();
                return false;
            }
        });
        this.mLisMsg.setKybdsScrollBottom(true);
        this.mLisMsg.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                View findViewById = view.findViewById(R.id.lay_msgitem_voice);
                if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
                    ((ChatVoiceView) findViewById).reset();
                }
                View findViewById2 = view.findViewById(R.id.emotion_msgitem_image);
                if (findViewById2 != null && (findViewById2 instanceof GifView)) {
                    ((GifView) findViewById2).stop();
                }
            }
        });
    }

    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setIsIM(true);
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setBackgroundColorId(R.color.CAM_X0204);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.fub != null && (this.mSendTool.fub instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.fub;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.fuU = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mTool.bE(arrayList);
        m sj = this.mTool.sj(5);
        if (sj != null) {
            sj.kv(false);
            sj.fuU = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false, false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.fub != null && (aVar.fub instanceof EditText)) {
            ((EditText) aVar.fub).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds36));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        aVar2.setTextColor(R.color.CAM_X0302);
        this.mTool.b(aVar2);
        this.mTool.build();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
    }

    private void initNewMsg(TalkableActivity talkableActivity) {
        this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(R.id.lay_last_msg);
        this.mTextNewMsg = (TextView) talkableActivity.findViewById(R.id.text_last_msg);
        this.mLayNewMsg.setOnClickListener(talkableActivity);
    }

    protected void initBottom(TalkableActivity talkableActivity) {
        this.mLayBottom = (ViewGroup) talkableActivity.findViewById(R.id.lay_bottom_bar);
    }

    public ViewGroup getLayoutBottom() {
        return this.mLayBottom;
    }

    public void bindDataAndRefresh(MsgPageData msgPageData, long j) {
        if (msgPageData != null) {
            this.mAdapter.setData(msgPageData.getChatMessages());
            this.mAdapter.notifyDataSetInvalidated();
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        this.mTexGroup.setText(au.getFixedText(str, 8, true));
        if (z) {
        }
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.personal_lbs_title_name.setText(str);
        if (bVar != null) {
            if (bVar.bAi() < 0 || bVar.bAi() > 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(8);
            } else if (bVar.bAi() == 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(R.string.contact_yinshen));
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_shadow.setVisibility(0);
                this.personal_lbs_title_time.setVisibility(0);
                this.personal_lbs_title_time.setText(au.getTimeInterval(bVar.getTime()));
                this.personal_lbs_title_lbsinfo.setText(bVar.getDistance());
            } else {
                this.personal_lbs_title_lbsinfo.setVisibility(8);
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
            }
        }
    }

    public void refresh() {
        this.mAdapter.notifyDataSetChanged();
    }

    private void doRefresh(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            try {
                this.mAdapter.setData(msgPageData.getChatMessages());
                this.mAdapter.notifyDataSetChanged();
                if (i >= 0) {
                    this.mLisMsg.setSelection(i);
                }
            } catch (Exception e) {
            }
        }
    }

    public void refreshNormal(MsgPageData msgPageData) {
        doRefresh(msgPageData, -1);
    }

    public void refreshGo2New(MsgPageData msgPageData) {
        if (msgPageData != null) {
            try {
                removeMoreData(msgPageData);
                int size = msgPageData.getChatMessages().size();
                int i = 0;
                if (size > 0) {
                    i = size - 1;
                }
                doRefresh(msgPageData, i);
            } catch (Exception e) {
                doRefresh(msgPageData, -1);
            }
        }
    }

    public void refreshPrepage(MsgPageData msgPageData) {
        try {
            int firstVisiblePosition = this.mLisMsg.getFirstVisiblePosition();
            if (msgPageData.getIsNewAdd()) {
                doRefresh(msgPageData, firstVisiblePosition + msgPageData.getNewAddNum());
            } else {
                doRefresh(msgPageData, -1);
            }
        } catch (Exception e) {
            doRefresh(msgPageData, -1);
        }
    }

    public String beforeSendMsgText() {
        if (TextUtils.isEmpty(this.mTextContent)) {
            return null;
        }
        return this.mTextContent;
    }

    public void afterSendMsgText() {
        this.mTextContent = null;
        if (this.mTool != null) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(9, -1, true));
        }
    }

    public void addAt2SendMsg(String str) {
        if (TextUtils.isEmpty(this.mTextContent)) {
            this.mTextContent = UgcConstant.AT_RULE_TAG + str + " ";
        } else {
            this.mTextContent += " @" + str + " ";
        }
        if (this.mTool != null) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(6, 3, this.mTextContent));
        }
    }

    public void refreshSendVoiceText(boolean z) {
        if (this.mSendVoiceView != null) {
            this.mSendVoiceView.refreshSendVoiceText(z);
        }
    }

    public void sendmsgCloseSoftkey() {
        if (this.mTool != null) {
            this.mTool.bAK();
        }
        l.hideSoftKeyPad(this.mContext.getActivity(), this.mContext.getCurrentFocus());
    }

    public void refreshCheckNew(MsgPageData msgPageData) {
        if (msgPageData != null) {
            boolean z = false;
            try {
                if (msgPageData.getIsNewAdd()) {
                    z = checkListAtNew(msgPageData.getNewAddNum());
                }
                if (z) {
                    refreshGo2New(msgPageData);
                    return;
                }
                refreshNormal(msgPageData);
                if (msgPageData.getNewAddNum() > 0 && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() > 0) {
                    showNewMsg(msgPageData.getChatMessages().get(msgPageData.getChatMessages().size() - 1));
                }
            } catch (Exception e) {
                doRefresh(msgPageData, -1);
            }
        }
    }

    public BdTypeListView getMsgListView() {
        return this.mLisMsg;
    }

    private boolean checkListAtNew(int i) {
        List<ChatMessage> data = this.mAdapter.getData();
        if (data == null) {
            return false;
        }
        if (data.size() <= i) {
            return true;
        }
        return this.mLisMsg.getLastVisiblePosition() == (data.size() - getOffset()) - i;
    }

    protected int getOffset() {
        return 1;
    }

    public FrameLayout getListMain() {
        return this.mListMain;
    }

    public void startRecordVoice() {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.startRecordVoice();
        }
    }

    public void stopRecordVoice() {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.stopRecordVoice();
        }
    }

    public void closeRecordTooShort() {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.closeRecordTooShort();
        }
    }

    public void showRecordCancel() {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.showRecordCancel();
        }
    }

    public void closeRecordCancel() {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.closeRecordCancel();
        }
    }

    private void showNewMsg(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.util.e.r(chatMessage)) {
            String content = getContent(chatMessage);
            if (!TextUtils.isEmpty(content)) {
                this.mLayNewMsg.setVisibility(0);
                this.mTextNewMsg.setText(content);
            }
        }
    }

    private String getContent(ChatMessage chatMessage) {
        return com.baidu.tieba.im.util.e.w(chatMessage);
    }

    public void closeNewMsg() {
        if (this.mLayNewMsg.getVisibility() == 0) {
            this.mLayNewMsg.setVisibility(8);
            this.mTextNewMsg.setText("");
        }
    }

    public void showDiaItemContentOperate(int i, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mContext.getPageContext());
            iVar.a(null, strArr, this.mContext);
            this.mMsgItemOperation = iVar;
            this.mMsgItemOperation.getContentView().setTag(Integer.valueOf(i));
            this.mMsgItemOperation.RU();
        }
    }

    public void closeProgress() {
        this.mPrgLisMsg.setVisibility(8);
    }

    public void displayNoNetwork() {
        this.mNetworkView.update(true);
    }

    public void hideNoNetwork() {
        this.mNetworkView.update(false);
    }

    public boolean isMoreVisible() {
        if (this.mTool == null) {
            return false;
        }
        return this.mTool.bCr();
    }

    public void hideMore() {
        if (this.mTool != null) {
            this.mTool.bAK();
        }
    }

    public View getBtnBack() {
        return this.mImgBack;
    }

    public View getBtnGroupInfo() {
        return this.mBtnGroupInfo;
    }

    public com.baidu.tbadk.core.dialog.i getMsgItemOperationDialog() {
        return this.mMsgItemOperation;
    }

    public LinearLayout getLayNewMsg() {
        return this.mLayNewMsg;
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStartedRecorder(boolean z) {
        if (z) {
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowErr(int i, String str) {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.onShowErr(i, str);
        }
        if (!StringUtils.isNull(str)) {
            if (i == 3) {
                this.mContext.showToast(str);
            } else if (i == 2) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 500L);
            } else {
                this.mContext.showToast(str);
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onSendVoice(String str, int i) {
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.mModel = voiceModel;
        if (this.mCallback != null) {
            this.mCallback.e(voiceModel);
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        if (this.mCallback != null) {
            this.mCallback.cTc();
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onShowRecording(int i) {
        if (this.mSendVoiceView != null) {
            this.mSendVoiceView.onShowRecording(i);
        }
    }

    public void setRecordCallback(a aVar) {
        this.mCallback = aVar;
    }

    public void closeReceiver() {
        this.mReceiver.setVisibility(8);
    }

    public void showReceiver() {
        this.mReceiver.setVisibility(0);
    }

    public void closeNotNotify() {
        this.mNotNotify.setVisibility(8);
    }

    public void showNotNotfiy() {
        this.mNotNotify.setVisibility(0);
    }

    public void setDraft(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
                if (this.mTool != null) {
                    this.mTool.b(new com.baidu.tbadk.editortools.a(6, 3, string));
                }
                this.mTextContent = string;
                if (jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.mTool != null) {
                    this.mTool.b(new com.baidu.tbadk.editortools.a(1, 6, null));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDraft() {
        String str;
        if (this.mTool == null) {
            return "";
        }
        m sj = this.mTool.sj(3);
        if (sj == null || sj.fub == null || !(sj.fub instanceof View)) {
            str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
        } else if (((View) sj.fub).getVisibility() == 0) {
            str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
        } else {
            str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.mTextContent);
        hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
        return OrmObject.jsonStrWithObject((DraftContent) OrmObject.objectWithMap(hashMap, DraftContent.class));
    }

    public View getBtnSendVoice() {
        if (this.mSendVoiceView == null || !(this.mSendVoiceView instanceof View)) {
            return null;
        }
        return (View) this.mSendVoiceView;
    }

    /* loaded from: classes.dex */
    public static class DraftContent extends OrmObject implements Serializable {
        private String input_draft;
        private String input_status;

        public void setInput_draft(String str) {
            this.input_draft = str;
        }

        public String getInput_draft() {
            return this.input_draft;
        }

        public void setInput_status(String str) {
            this.input_status = str;
        }

        public String getInput_status() {
            return this.input_status;
        }
    }

    public void onDestory() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
        }
        if (this.mAdapter != null) {
            this.mAdapter.onDestory();
        }
    }

    private void removeMoreData(MsgPageData msgPageData) {
        int size;
        if (msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.getChatMessages().size() != 0 && (size = msgPageData.getChatMessages().size()) > 100) {
            int i = size - 100;
            for (int i2 = 0; i2 < i; i2++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public void updateAdapter(int i, ChatMessage chatMessage) {
        chatMessage.setProgressValue(i);
        this.mAdapter.e(chatMessage);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundColor(this.mListMain, R.color.CAM_X0204);
        if (this.personal_lbs_title_name != null) {
            ap.setViewTextColor(this.personal_lbs_title_name, R.color.CAM_X0105, 1);
        }
        if (this.personal_lbs_title_lbsinfo != null) {
            ap.setViewTextColor(this.personal_lbs_title_lbsinfo, R.color.CAM_X0105, 1);
        }
        if (this.personal_lbs_title_time != null) {
            ap.setViewTextColor(this.personal_lbs_title_time, R.color.CAM_X0105, 1);
        }
        if (this.mTexGroup != null) {
            ap.setViewTextColor(this.mTexGroup, R.color.CAM_X0105, 1);
        }
        this.mNetworkView.onChangeSkinType(getPageContext(), i);
        if (this.mTool != null) {
            this.mTool.onChangeSkinType(i);
        }
        if (this.mNotNotify != null) {
            ap.setImageResource(this.mNotNotify, R.drawable.icon_chat_call_not);
        }
        this.mNavigationBar.onBackBtnOnChangeSkin();
    }

    protected void onSendEmotion() {
    }
}
