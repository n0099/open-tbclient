package com.baidu.tieba.im.chat;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class AbsMsglistView extends com.baidu.adp.base.g<MsglistActivity<?>> implements com.baidu.adp.lib.voice.j, com.baidu.tbadk.editortool.v {
    private static final int MAX_MSG_COUNT = 100;
    private static final int RECORD_LAYER_TIP_DURATION = 500;
    private static final int SHOW_RECORD_LAYER_TIP = 1;
    protected ca mAdapter;
    protected View mBtnGroupInfo;
    protected ImageView mBtnMsgSendGovoice;
    protected ImageView mBtnMsgSendMore1;
    protected ImageView mBtnMsgSendMore2;
    protected ImageView mBtnMsgSendSoftkey;
    private RelativeLayout mBtnMsgSendVoice;
    private Button mBtnMsgsendSend;
    private w mCallback;
    protected MsglistActivity mContext;
    protected EditText mEdtMsgSendText;
    protected EmotionTabHost mFaceView;
    private av mFloatRecordView;
    private final Handler mHandler;
    private View mImgBack;
    protected FrameLayout mInputControl;
    protected ViewGroup mLayBottom;
    private LinearLayout mLayMsgSendText;
    private LinearLayout mLayMsgSendVoice;
    private ToolMoreView mLayMsgsendMore;
    private LinearLayout mLayNewMsg;
    private BdTypeListView mLisMsg;
    private FrameLayout mListMain;
    private VoiceData.VoiceModel mModel;
    protected com.baidu.tbadk.core.dialog.e mMsgItemOperation;
    protected NavigationBar mNavigationBar;
    protected boolean mNeedShowName;
    private NoNetworkView mNetworkView;
    private ImageView mNotNotify;
    private ProgressBar mPrgLisMsg;
    private ImageView mReceiver;
    private final com.baidu.tbadk.core.dialog.a mResendDialog;
    protected KeyboardLayout mRootView;
    private aw mSendVoiceView;
    private TextView mTexGroup;
    private TextView mTextNewMsg;
    private View personal_lbs_shadow;
    private TextView personal_lbs_title_lbsinfo;
    private TextView personal_lbs_title_name;
    private TextView personal_lbs_title_time;
    private View personalchat_lbs_title;

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
        this.mLayMsgSendVoice = null;
        this.mBtnMsgSendSoftkey = null;
        this.mBtnMsgSendMore1 = null;
        this.mBtnMsgSendVoice = null;
        this.mSendVoiceView = null;
        this.mFloatRecordView = null;
        this.mLayMsgSendText = null;
        this.mBtnMsgSendGovoice = null;
        this.mBtnMsgSendMore2 = null;
        this.mBtnMsgsendSend = null;
        this.mEdtMsgSendText = null;
        this.mLayMsgsendMore = null;
        this.mFaceView = null;
        this.mLayNewMsg = null;
        this.mTextNewMsg = null;
        this.mContext = null;
        this.mMsgItemOperation = null;
        this.mResendDialog = null;
        this.mLayBottom = null;
        this.mHandler = new i(this);
        this.mNeedShowName = true;
        this.mRootView = null;
        this.mContext = msglistActivity;
        msglistActivity.setContentView(com.baidu.tieba.r.msg_msglist_activity);
        this.mRootView = (KeyboardLayout) msglistActivity.findViewById(com.baidu.tieba.q.msg_root_view);
        initHeader(msglistActivity, z);
        initNoNetwork(msglistActivity);
        initMsglist(msglistActivity);
        initMsgsendVoice(msglistActivity);
        initMsgsendText(msglistActivity);
        initMsgsendMore(msglistActivity);
        initNewMsg(msglistActivity);
        initBottom(msglistActivity);
    }

    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(com.baidu.tieba.q.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mTexGroup = this.mNavigationBar.setTitleText("");
        this.mNotNotify = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.msg_chat_top_notify, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.q.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        this.mNavigationBar = (NavigationBar) talkableActivity.findViewById(com.baidu.tieba.q.lay_title_bar);
        this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.personalchat_lbs_title = com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst(), com.baidu.tieba.r.personal_chat_lbs_title, null);
        this.personal_lbs_title_name = (TextView) this.personalchat_lbs_title.findViewById(com.baidu.tieba.q.personal_lbs_title_name);
        this.personal_lbs_title_lbsinfo = (TextView) this.personalchat_lbs_title.findViewById(com.baidu.tieba.q.personal_lbs_title_lbsinfo);
        this.personal_lbs_title_time = (TextView) this.personalchat_lbs_title.findViewById(com.baidu.tieba.q.personal_lbs_title_time);
        this.personal_lbs_shadow = this.personalchat_lbs_title.findViewById(com.baidu.tieba.q.personal_lbs_shadow);
        this.mNavigationBar.setTitleView(this.personalchat_lbs_title, (View.OnClickListener) null);
        this.mNotNotify = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.msg_chat_top_notify, (View.OnClickListener) null);
        this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.msg_chat_ear_item, (View.OnClickListener) null);
        this.mInputControl = (FrameLayout) talkableActivity.findViewById(com.baidu.tieba.q.layout_bottom_input);
        if (z) {
            closeNotNotify();
        } else {
            showNotNotfiy();
        }
    }

    private void initNoNetwork(TalkableActivity talkableActivity) {
        this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(com.baidu.tieba.q.view_no_network);
    }

    public ca getAdapter() {
        return this.mAdapter;
    }

    public void MainOnTouch() {
    }

    protected void initMsglist(MsglistActivity msglistActivity) {
        this.mListMain = (FrameLayout) msglistActivity.findViewById(com.baidu.tieba.q.layout_main);
        this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(com.baidu.tieba.q.lis_msg);
        this.mPrgLisMsg = (ProgressBar) msglistActivity.findViewById(com.baidu.tieba.q.msg_progress);
        this.mPrgLisMsg.setVisibility(8);
        this.mAdapter = new ca(msglistActivity.getPageContext(), this.mLisMsg);
        setNeedShowName();
        this.mAdapter.cA(this.mNeedShowName);
        this.mAdapter.cB(isPersonal());
        this.mAdapter.a(msglistActivity);
        this.mAdapter.setOnItemViewLongClickListener(msglistActivity);
        this.mLisMsg.setOnScrollListener(new o(this));
        this.mLisMsg.setOnSrollToTopListener(msglistActivity);
        this.mLisMsg.setOnSrollToBottomListener(msglistActivity);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        this.mLisMsg.setOnTouchListener(new p(this));
        this.mLisMsg.setKybdsScrollBottom(true);
        this.mLisMsg.setRecyclerListener(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initMsgsendVoice(MsglistActivity msglistActivity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001308, aw.class, this.mInputControl);
        if (runTask != null && runTask.getData() != null) {
            this.mSendVoiceView = (aw) runTask.getData();
        }
        if (this.mSendVoiceView == null) {
            this.mBtnMsgSendSoftkey = new ImageView(msglistActivity.getBaseContext());
            this.mBtnMsgSendSoftkey.setVisibility(8);
            this.mBtnMsgSendMore1 = new ImageView(msglistActivity.getBaseContext());
            this.mBtnMsgSendMore1.setVisibility(8);
            this.mInputControl.addView(this.mBtnMsgSendSoftkey);
            this.mInputControl.addView(this.mBtnMsgSendMore1);
            return;
        }
        this.mLayMsgSendVoice = this.mSendVoiceView.op();
        if (this.mLayMsgSendVoice != null) {
            this.mLayMsgSendVoice.setVisibility(8);
        }
        this.mBtnMsgSendSoftkey = this.mSendVoiceView.oo();
        if (this.mBtnMsgSendSoftkey != null) {
            this.mBtnMsgSendSoftkey.setOnClickListener(new r(this));
        }
        this.mBtnMsgSendMore1 = this.mSendVoiceView.on();
        if (this.mBtnMsgSendMore1 != null) {
            this.mBtnMsgSendMore1.setOnClickListener(new s(this));
        }
        this.mBtnMsgSendVoice = this.mSendVoiceView.getBtnSendVoice();
        if (this.mBtnMsgSendVoice != null) {
            this.mBtnMsgSendVoice.setOnTouchListener(msglistActivity);
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001307, av.class, this.mRootView);
        if (runTask2 != null && runTask2.getData() != null) {
            this.mFloatRecordView = (av) runTask2.getData();
        }
        if (!com.baidu.tieba.tbadkCore.voice.d.apG()) {
            this.mBtnMsgSendGovoice = (ImageView) msglistActivity.findViewById(com.baidu.tieba.q.btn_msgsend_govoice);
            if (this.mBtnMsgSendSoftkey != null) {
                this.mBtnMsgSendSoftkey.setVisibility(8);
            }
            if (this.mBtnMsgSendGovoice != null) {
                this.mBtnMsgSendGovoice.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSoftkeyEvent() {
        sendmsgCloseMore();
        sendmsgShowText();
        if (this.mBtnMsgSendSoftkey != null) {
            this.mBtnMsgSendSoftkey.postDelayed(new t(this), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SendMore1Event() {
        sendmsgCloseSoftkey();
        sendmsgShowMore();
        sendmsgShowText();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initMsgsendText(TalkableActivity talkableActivity) {
        this.mLayMsgSendText = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.q.lay_msgsend_text);
        this.mLayMsgSendText.setVisibility(0);
        this.mBtnMsgSendGovoice = (ImageView) talkableActivity.findViewById(com.baidu.tieba.q.btn_msgsend_govoice);
        if (this.mSendVoiceView != null) {
            this.mBtnMsgSendGovoice.setImageResource(this.mSendVoiceView.om());
        }
        this.mBtnMsgSendGovoice.setOnClickListener(new u(this));
        this.mBtnMsgSendMore2 = (ImageView) talkableActivity.findViewById(com.baidu.tieba.q.btn_msgsend_more2);
        this.mBtnMsgSendMore2.setOnClickListener(new v(this));
        this.mEdtMsgSendText = (EditText) talkableActivity.findViewById(com.baidu.tieba.q.edt_msgsend_text);
        this.mEdtMsgSendText.setCursorVisible(false);
        this.mEdtMsgSendText.setFocusable(true);
        this.mEdtMsgSendText.setFocusableInTouchMode(true);
        this.mEdtMsgSendText.addTextChangedListener(new j(this));
        this.mEdtMsgSendText.setOnTouchListener(new k(this));
        this.mBtnMsgsendSend = (Button) talkableActivity.findViewById(com.baidu.tieba.q.btn_msgsend_send);
        this.mBtnMsgsendSend.setOnClickListener(talkableActivity);
        this.mBtnMsgsendSend.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendGovoiceEvent() {
        sendmsgCloseSoftkey();
        sendmsgCloseExpression();
        sendmsgCloseMore();
        sendmsgShowVoice();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMore2Event() {
        sendmsgCloseSoftkey();
        this.mBtnMsgSendMore2.postDelayed(new l(this), 100L);
    }

    private void initMsgsendMore(TalkableActivity talkableActivity) {
        this.mLayMsgsendMore = (ToolMoreView) talkableActivity.findViewById(com.baidu.tieba.q.lay_msgsend_more);
        this.mLayMsgsendMore.setVisibility(8);
        this.mLayMsgsendMore.setOnClickListener(talkableActivity);
        this.mLayMsgsendMore.zS();
        initExpression(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initExpression(TalkableActivity talkableActivity) {
        this.mFaceView = (EmotionTabHost) talkableActivity.findViewById(com.baidu.tieba.q.face_view);
        this.mFaceView.setOnDataSelected(this);
        this.mFaceView.setIsInChat(true);
        this.mLayMsgsendMore.getFaceButton().setOnClickListener(new m(this));
    }

    private void initNewMsg(TalkableActivity talkableActivity) {
        this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(com.baidu.tieba.q.lay_last_msg);
        this.mTextNewMsg = (TextView) talkableActivity.findViewById(com.baidu.tieba.q.text_last_msg);
        this.mLayNewMsg.setOnClickListener(talkableActivity);
    }

    protected void initBottom(TalkableActivity talkableActivity) {
        this.mLayBottom = (ViewGroup) talkableActivity.findViewById(com.baidu.tieba.q.lay_bottom_bar);
    }

    public ViewGroup getLayoutBottom() {
        return this.mLayBottom;
    }

    public void sendmsgCloseSoftkey() {
        HidenSoftKeyPad(this.mEdtMsgSendText);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendmsgCloseMore() {
        this.mLayMsgsendMore.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendmsgCloseExpression() {
        this.mFaceView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendmsgShowText() {
        if (this.mLayMsgSendVoice != null) {
            this.mLayMsgSendVoice.setVisibility(8);
        }
        this.mLayMsgSendText.setVisibility(0);
    }

    private void sendmsgShowVoice() {
        if (com.baidu.tieba.tbadkCore.voice.d.apG()) {
            if (this.mLayMsgSendVoice != null) {
                this.mLayMsgSendVoice.setVisibility(0);
            }
            this.mLayMsgSendText.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendmsgShowSoftkey() {
        listGo2New();
        this.mEdtMsgSendText.setCursorVisible(true);
        this.mEdtMsgSendText.requestFocus();
        ShowSoftKeyPadDelay(this.mEdtMsgSendText, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendmsgShowExpression() {
        this.mEdtMsgSendText.requestFocus();
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mFaceView.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.mFaceView.setLayoutParams(layoutParams);
        }
        this.mFaceView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditTextSelectLast() {
        new Handler().postDelayed(new n(this), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listGo2New() {
        List<ChatMessage> data = this.mAdapter.getData();
        if (data != null && data.size() > 0) {
            this.mLisMsg.setSelection(data.size() - 1);
            closeNewMsg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendmsgShowMore() {
        if (this.mLayMsgsendMore.getVisibility() != 0) {
            if (this.mFaceView.getVisibility() == 0) {
                this.mFaceView.setVisibility(8);
                if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLayMsgsendMore.getLayoutParams();
                    layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                    this.mLayMsgsendMore.setLayoutParams(layoutParams);
                }
                this.mLayMsgsendMore.setVisibility(0);
                return;
            }
            if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mLayMsgsendMore.getLayoutParams();
                layoutParams2.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                this.mLayMsgsendMore.setLayoutParams(layoutParams2);
            }
            this.mLayMsgsendMore.setVisibility(0);
        }
    }

    public void bindDataAndRefresh(MsgPageData msgPageData, int i) {
        if (msgPageData != null) {
            this.mAdapter.setData(msgPageData.getChatMessages());
            this.mAdapter.notifyDataSetInvalidated();
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        this.mTexGroup.setText(str);
    }

    public void refreshPersonalHeadFooter(String str, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.personal_lbs_title_name.setText(str);
        if (bVar != null) {
            if (bVar.xx() < 0 || bVar.xx() > 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(8);
            } else if (bVar.xx() == 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(com.baidu.tieba.t.contact_yinshen));
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.getDistance()) && bVar.getTime() > 0) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_shadow.setVisibility(0);
                this.personal_lbs_title_time.setVisibility(0);
                this.personal_lbs_title_time.setText(bb.n(bVar.getTime()));
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
        String editable = this.mEdtMsgSendText.getText().toString();
        if (TextUtils.isEmpty(editable)) {
            return null;
        }
        return editable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkTextNum() {
        return Pattern.compile("\\s*|\t|\r|\n").matcher(this.mEdtMsgSendText.getText().toString()).replaceAll("").length() != 0;
    }

    public void afterSendMsgText() {
        this.mEdtMsgSendText.setText("");
    }

    public void showErr(int i, String str) {
        if (str != null) {
            com.baidu.adp.lib.util.n.showToast(this.mContext.getPageContext().getContext(), str);
            return;
        }
        String errMsg = TbErrInfo.getErrMsg(i);
        if (errMsg != null && errMsg.length() > 0) {
            com.baidu.adp.lib.util.n.showToast(this.mContext.getPageContext().getContext(), errMsg);
        }
    }

    public void addAt2SendMsg(String str) {
        String editable;
        String str2;
        if (this.mEdtMsgSendText.getText().toString().equals("")) {
            str2 = "@" + str + " ";
        } else {
            str2 = String.valueOf(editable) + " @" + str + " ";
        }
        this.mEdtMsgSendText.setText(str2);
        this.mEdtMsgSendText.setSelection(str2.length());
        sendmsgCloseMore();
        sendmsgCloseExpression();
        sendmsgShowText();
        sendmsgShowSoftkey();
    }

    public void refreshSendVoiceText(boolean z) {
        if (this.mSendVoiceView != null) {
            this.mSendVoiceView.refreshSendVoiceText(z);
        }
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
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.startRecordVoice();
        }
    }

    public void stopRecordVoice() {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.stopRecordVoice();
        }
    }

    public void showRecordTooShort() {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.showRecordTooShort();
        }
    }

    public void closeRecordTooShort() {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.closeRecordTooShort();
        }
    }

    public void showRecordCancel() {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.showRecordCancel();
        }
    }

    public void closeRecordCancel() {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.closeRecordCancel();
        }
    }

    private void showNewMsg(ChatMessage chatMessage) {
        if (chatMessage != null && !com.baidu.tieba.im.util.i.s(chatMessage)) {
            String content = getContent(chatMessage);
            if (!TextUtils.isEmpty(content)) {
                this.mLayNewMsg.setVisibility(0);
                this.mTextNewMsg.setText(content);
            }
        }
    }

    private String getContent(ChatMessage chatMessage) {
        return com.baidu.tieba.im.util.i.x(chatMessage);
    }

    public void closeNewMsg() {
        if (this.mLayNewMsg.getVisibility() == 0) {
            this.mLayNewMsg.setVisibility(8);
            this.mTextNewMsg.setText("");
        }
    }

    public void showDiaItemContentOperate(int i, String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(this.mContext.getPageContext().getPageActivity());
            eVar.bx(com.baidu.tieba.t.operation);
            eVar.a(strArr, this.mContext);
            this.mMsgItemOperation = eVar;
            this.mMsgItemOperation.d(this.mContext.getPageContext());
            this.mMsgItemOperation.getRootView().setTag(Integer.valueOf(i));
            this.mMsgItemOperation.rN();
        }
    }

    public void showProgress() {
        this.mPrgLisMsg.setVisibility(0);
    }

    public void closeProgress() {
        this.mPrgLisMsg.setVisibility(8);
    }

    NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    public void displayNoNetwork() {
        this.mNetworkView.at(true);
    }

    public void hideNoNetwork() {
        this.mNetworkView.at(false);
    }

    public boolean isMoreVisible() {
        return this.mFaceView.getVisibility() == 0 || this.mLayMsgsendMore.getVisibility() == 0;
    }

    public void hideMore() {
        if (this.mFaceView.getVisibility() == 0) {
            this.mFaceView.setVisibility(8);
        }
        if (this.mLayMsgsendMore.getVisibility() == 0) {
            this.mLayMsgsendMore.setVisibility(8);
        }
    }

    public View getBtnBack() {
        return this.mImgBack;
    }

    public Button getBtnSend() {
        return this.mBtnMsgsendSend;
    }

    public View getBtnExpression() {
        return this.mLayMsgsendMore.getFaceButton();
    }

    public View getBtnImage() {
        return this.mLayMsgsendMore.getImageButton();
    }

    public View getBtnGroupInfo() {
        return this.mBtnGroupInfo;
    }

    public RelativeLayout getBtnSendVoice() {
        return this.mBtnMsgSendVoice;
    }

    public com.baidu.tbadk.core.dialog.e getMsgItemOperationDialog() {
        return this.mMsgItemOperation;
    }

    public LinearLayout getLayNewMsg() {
        return this.mLayNewMsg;
    }

    public com.baidu.tbadk.core.dialog.a getResendDialog() {
        return this.mResendDialog;
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStartedRecorder(boolean z) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onStopingRecorder() {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowErr(int i, String str) {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.onShowErr(i, str);
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

    @Override // com.baidu.adp.lib.voice.j
    public void onSendVoice(String str, int i) {
        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
        voiceModel.duration = i;
        voiceModel.voiceId = str;
        voiceModel.voice_status = 1;
        this.mModel = voiceModel;
        if (this.mCallback != null) {
            this.mCallback.c(voiceModel);
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onDeletedVoice(String str) {
        this.mModel = null;
        if (this.mCallback != null) {
            this.mCallback.OV();
        }
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecordTime(int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void onShowRecording(int i) {
        if (this.mFloatRecordView != null) {
            this.mFloatRecordView.onShowRecording(i);
        }
    }

    public void setRecordCallback(w wVar) {
        this.mCallback = wVar;
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mModel;
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
                this.mEdtMsgSendText.setText(jSONObject.getString("input_draft"));
                this.mEdtMsgSendText.setSelection(this.mEdtMsgSendText.getText().toString().length());
                if (jSONObject.getString("input_status").equals("input_voice")) {
                    sendmsgShowVoice();
                } else {
                    sendmsgShowText();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDraft() {
        String str;
        if (this.mLayMsgSendText.getVisibility() == 0) {
            str = "input_text";
        } else {
            str = "input_voice";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("input_draft", this.mEdtMsgSendText.getText().toString());
        hashMap.put("input_status", str);
        return com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject((DraftContent) com.baidu.adp.lib.a.b.a.a.i.objectWithMap(hashMap, DraftContent.class));
    }

    /* loaded from: classes.dex */
    public class DraftContent extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
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
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mNetworkView.onChangeSkinType(getPageContext(), 0);
        this.mFaceView.onChangeSkinType(0);
        this.mLayMsgsendMore.onChangeSkinType(0);
    }

    protected void onSendEmotion() {
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                EmotionGroupType vm = fVar.vm();
                String name = fVar.getName();
                if (vm == EmotionGroupType.LOCAL) {
                    if (name != null) {
                        this.mEdtMsgSendText.getText().insert(this.mEdtMsgSendText.getSelectionStart(), name);
                    }
                } else if (name != null) {
                    this.mContext.sendBigEmotionMsg(fVar);
                    onSendEmotion();
                }
            }
        } else if (i == 21 && this.mEdtMsgSendText.getSelectionStart() > 0) {
            String substring = this.mEdtMsgSendText.getText().toString().substring(0, this.mEdtMsgSendText.getSelectionStart());
            Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
            if (matcher.find()) {
                this.mEdtMsgSendText.getText().delete(this.mEdtMsgSendText.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.mEdtMsgSendText.getSelectionStart());
                return;
            }
            this.mEdtMsgSendText.getText().delete(this.mEdtMsgSendText.getSelectionStart() - 1, this.mEdtMsgSendText.getSelectionStart());
        }
    }

    public void disableSend() {
        getBtnImage().setEnabled(false);
        if (this.mBtnMsgSendVoice != null) {
            this.mBtnMsgSendVoice.setEnabled(false);
        }
        this.mBtnMsgSendGovoice.setEnabled(false);
        getBtnExpression().setEnabled(false);
        if (this.mBtnMsgSendMore1 != null) {
            this.mBtnMsgSendMore1.setEnabled(false);
        }
        this.mBtnMsgSendMore2.setEnabled(false);
        this.mEdtMsgSendText.setEnabled(false);
        this.mBtnMsgsendSend.setEnabled(false);
    }
}
