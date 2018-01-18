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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.b;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.d;
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
    protected b mActionListener;
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
    protected com.baidu.tbadk.core.dialog.b mMsgItemOperation;
    protected NavigationBar mNavigationBar;
    protected boolean mNeedShowName;
    private NoNetworkView mNetworkView;
    private ImageView mNotNotify;
    private ProgressBar mPrgLisMsg;
    private ImageView mReceiver;
    private final com.baidu.tbadk.core.dialog.a mResendDialog;
    protected KeyboardLayout mRootView;
    protected r mSendTool;
    protected ISendVoiceView mSendVoiceView;
    private TextView mTexGroup;
    private String mTextContent;
    private TextView mTextNewMsg;
    protected com.baidu.tbadk.editortools.i mTool;
    private View personal_lbs_shadow;
    private TextView personal_lbs_title_lbsinfo;
    private TextView personal_lbs_title_name;
    private TextView personal_lbs_title_time;
    private View personalchat_lbs_title;

    /* loaded from: classes.dex */
    public interface a {
        void aDN();

        void d(VoiceData.VoiceModel voiceModel);
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
        this.mActionListener = new b() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.1
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar != null) {
                    if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof n)) {
                            n nVar = (n) aVar.data;
                            EmotionGroupType Fr = nVar.Fr();
                            String name = nVar.getName();
                            if (Fr != EmotionGroupType.LOCAL && name != null) {
                                AbsMsglistView.this.mContext.c(nVar);
                                AbsMsglistView.this.onSendEmotion();
                            }
                        }
                    } else if (aVar.code == 8) {
                        AbsMsglistView.this.mContext.aEB();
                    } else if (aVar.code == 4) {
                        if (aVar.data != null && (aVar.data instanceof String)) {
                            AbsMsglistView.this.mTextContent = (String) aVar.data;
                        }
                    } else if (aVar.code == 14) {
                        AbsMsglistView.this.mContext.aEC();
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
        msglistActivity.setContentView(d.h.msg_msglist_activity);
        this.mRootView = (KeyboardLayout) msglistActivity.findViewById(d.g.msg_root_view);
        initHeader(msglistActivity, z);
        initNoNetwork(msglistActivity);
        initMsglist(msglistActivity);
        initMsgSend(msglistActivity);
        initNewMsg(msglistActivity);
        initBottom(msglistActivity);
    }

    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(d.g.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mBackImage = this.mNavigationBar.getBackImageView();
        this.mTexGroup = this.mNavigationBar.setCenterTextTitle("");
        this.mNotNotify = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.msg_chat_top_notify, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(d.g.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(d.g.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mBackImage = this.mNavigationBar.getBackImageView();
        this.personalchat_lbs_title = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(d.h.personal_chat_lbs_title, (ViewGroup) null);
        this.personal_lbs_title_name = (TextView) this.personalchat_lbs_title.findViewById(d.g.personal_lbs_title_name);
        this.personal_lbs_title_lbsinfo = (TextView) this.personalchat_lbs_title.findViewById(d.g.personal_lbs_title_lbsinfo);
        this.personal_lbs_title_time = (TextView) this.personalchat_lbs_title.findViewById(d.g.personal_lbs_title_time);
        this.mNotNotify = (ImageView) this.personalchat_lbs_title.findViewById(d.g.img_close_notify);
        this.personal_lbs_shadow = this.personalchat_lbs_title.findViewById(d.g.personal_lbs_shadow);
        this.mNavigationBar.setTitleView(this.personalchat_lbs_title, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(d.g.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    private void initNoNetwork(TalkableActivity talkableActivity) {
        this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(d.g.view_no_network);
    }

    public h getAdapter() {
        return this.mAdapter;
    }

    public void MainOnTouch() {
    }

    protected void initMsglist(final MsglistActivity msglistActivity) {
        this.mListMain = (FrameLayout) msglistActivity.findViewById(d.g.layout_main);
        this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(d.g.lis_msg);
        this.mPrgLisMsg = (ProgressBar) msglistActivity.findViewById(d.g.msg_progress);
        this.mPrgLisMsg.setVisibility(8);
        this.mAdapter = new h(msglistActivity.getPageContext(), this.mLisMsg);
        setNeedShowName();
        this.mAdapter.gQ(this.mNeedShowName);
        this.mAdapter.gR(isPersonal());
        this.mAdapter.a(msglistActivity);
        this.mAdapter.setOnItemViewLongClickListener(msglistActivity);
        this.mLisMsg.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                l.a(msglistActivity.getActivity(), msglistActivity.getActivity().getCurrentFocus());
                if (AbsMsglistView.this.mTool != null) {
                    AbsMsglistView.this.mTool.IE();
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
                l.a(msglistActivity.getActivity(), msglistActivity.getActivity().getCurrentFocus());
                if (AbsMsglistView.this.mTool != null) {
                    AbsMsglistView.this.mTool.IE();
                }
                AbsMsglistView.this.MainOnTouch();
                return false;
            }
        });
        this.mLisMsg.setKybdsScrollBottom(true);
        this.mLisMsg.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.im.chat.AbsMsglistView.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                View findViewById = view.findViewById(d.g.lay_msgitem_voice);
                if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
                    ((ChatVoiceView) findViewById).reset();
                }
                View findViewById2 = view.findViewById(d.g.emotion_msgitem_image);
                if (findViewById2 != null && (findViewById2 instanceof GifView)) {
                    ((GifView) findViewById2).stop();
                }
            }
        });
    }

    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new com.baidu.tbadk.editortools.i(talkableActivity.getActivity());
        this.mTool.setIsIM(true);
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(d.C0107d.cp_bg_line_c);
        this.mTool.setMoreDeskBgColorId(d.C0107d.cp_bg_line_c);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, r.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (r) runTask.getData();
            if (this.mSendTool.bqa != null && (this.mSendTool.bqa instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.bqa;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.bqP = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mTool.I(arrayList);
        r hJ = this.mTool.hJ(5);
        if (hJ != null) {
            hJ.cd(false);
            hJ.bqP = 3;
            hJ.bqN = d.f.btn_pb_add_expression;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false, false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.bqa != null && (aVar.bqa instanceof EditText)) {
            ((EditText) aVar.bqa).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(d.e.ds36));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(d.j.send_msg);
        this.mTool.b(aVar2);
        this.mTool.Kv();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.a(24, this.mActionListener);
        this.mTool.a(8, this.mActionListener);
        this.mTool.a(4, this.mActionListener);
        this.mTool.a(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
    }

    private void initNewMsg(TalkableActivity talkableActivity) {
        this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(d.g.lay_last_msg);
        this.mTextNewMsg = (TextView) talkableActivity.findViewById(d.g.text_last_msg);
        this.mLayNewMsg.setOnClickListener(talkableActivity);
    }

    protected void initBottom(TalkableActivity talkableActivity) {
        this.mLayBottom = (ViewGroup) talkableActivity.findViewById(d.g.lay_bottom_bar);
    }

    public ViewGroup getLayoutBottom() {
        return this.mLayBottom;
    }

    public void bindDataAndRefresh(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.mAdapter.setData(msgPageData.getChatMessages());
            this.mAdapter.notifyDataSetInvalidated();
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        this.mTexGroup.setText(am.getFixedText(str, 8, true));
        if (z) {
        }
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.personal_lbs_title_name.setText(str);
        if (bVar != null) {
            if (bVar.Io() < 0 || bVar.Io() > 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(8);
            } else if (bVar.Io() == 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(d.j.contact_yinshen));
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.In()) && bVar.getTime() > 0) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_shadow.setVisibility(0);
                this.personal_lbs_title_time.setVisibility(0);
                this.personal_lbs_title_time.setText(am.x(bVar.getTime()));
                this.personal_lbs_title_lbsinfo.setText(bVar.In());
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
            this.mTextContent = "@" + str + " ";
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
            this.mTool.IE();
        }
        l.a(this.mContext.getActivity(), this.mContext.getCurrentFocus());
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
        if (chatMessage != null && !com.baidu.tieba.im.util.e.w(chatMessage)) {
            String content = getContent(chatMessage);
            if (!TextUtils.isEmpty(content)) {
                this.mLayNewMsg.setVisibility(0);
                this.mTextNewMsg.setText(content);
            }
        }
    }

    private String getContent(ChatMessage chatMessage) {
        return com.baidu.tieba.im.util.e.B(chatMessage);
    }

    public void closeNewMsg() {
        if (this.mLayNewMsg.getVisibility() == 0) {
            this.mLayNewMsg.setVisibility(8);
            this.mTextNewMsg.setText("");
        }
    }

    public void showDiaItemContentOperate(int i, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mContext.getPageContext().getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(strArr, this.mContext);
            this.mMsgItemOperation = bVar;
            this.mMsgItemOperation.d(this.mContext.getPageContext());
            this.mMsgItemOperation.getRootView().setTag(Integer.valueOf(i));
            this.mMsgItemOperation.AD();
        }
    }

    public void closeProgress() {
        this.mPrgLisMsg.setVisibility(8);
    }

    public void displayNoNetwork() {
        this.mNetworkView.bo(true);
    }

    public void hideNoNetwork() {
        this.mNetworkView.bo(false);
    }

    public boolean isMoreVisible() {
        if (this.mTool == null) {
            return false;
        }
        return this.mTool.Kx();
    }

    public void hideMore() {
        if (this.mTool != null) {
            this.mTool.IE();
        }
    }

    public View getBtnBack() {
        return this.mImgBack;
    }

    public View getBtnGroupInfo() {
        return this.mBtnGroupInfo;
    }

    public com.baidu.tbadk.core.dialog.b getMsgItemOperationDialog() {
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
            this.mCallback.d(voiceModel);
        }
    }

    @Override // com.baidu.adp.lib.voice.f
    public void onDeletedVoice(String str) {
        this.mModel = null;
        if (this.mCallback != null) {
            this.mCallback.aDN();
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
                String string = jSONObject.getString("input_draft");
                if (this.mTool != null) {
                    this.mTool.b(new com.baidu.tbadk.editortools.a(6, 3, string));
                }
                this.mTextContent = string;
                if (jSONObject.getString("input_status").equals("input_voice") && this.mTool != null) {
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
        r hJ = this.mTool.hJ(3);
        if (hJ == null || hJ.bqa == null || !(hJ.bqa instanceof View)) {
            str = "input_text";
        } else if (((View) hJ.bqa).getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.mTextContent);
        hashMap.put("input_status", str);
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
        this.mAdapter.j(chatMessage);
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        if (this.personal_lbs_title_name != null) {
            aj.e(this.personal_lbs_title_name, d.C0107d.cp_cont_b, 1);
        }
        if (this.personal_lbs_title_lbsinfo != null) {
            aj.e(this.personal_lbs_title_lbsinfo, d.C0107d.cp_cont_b, 1);
        }
        if (this.personal_lbs_title_time != null) {
            aj.e(this.personal_lbs_title_time, d.C0107d.cp_cont_b, 1);
        }
        if (this.mTexGroup != null) {
            aj.e(this.mTexGroup, d.C0107d.cp_cont_b, 1);
        }
        this.mNetworkView.onChangeSkinType(getPageContext(), 0);
        if (this.mTool != null) {
            this.mTool.onChangeSkinType(0);
        }
        if (this.mNotNotify != null) {
            aj.c(this.mNotNotify, d.f.icon_chat_call_not);
        }
        this.mNavigationBar.onBackBtnOnChangeSkin();
    }

    protected void onSendEmotion() {
    }
}
