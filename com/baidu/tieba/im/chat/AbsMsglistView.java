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
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import d.a.c.e.p.l;
import d.a.m0.r.s.j;
import d.a.m0.s.c.v;
import d.a.m0.w.m;
import d.a.m0.w.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.CoroutineContextKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class AbsMsglistView extends d.a.c.a.d<MsglistActivity<?>> implements d.a.c.e.q.f {
    public d.a.m0.w.b mActionListener;
    public d.a.n0.f1.f.f mAdapter;
    public ImageView mBackImage;
    public View mBtnGroupInfo;
    public f mCallback;
    public MsglistActivity mContext;
    public final Handler mHandler;
    public View mImgBack;
    public FrameLayout mInputControl;
    public ViewGroup mLayBottom;
    public LinearLayout mLayNewMsg;
    public BdTypeListView mLisMsg;
    public FrameLayout mListMain;
    public j mMsgItemOperation;
    public NavigationBar mNavigationBar;
    public boolean mNeedShowName;
    public NoNetworkView mNetworkView;
    public ImageView mNotNotify;
    public ProgressBar mPrgLisMsg;
    public ImageView mReceiver;
    public KeyboardLayout mRootView;
    public m mSendTool;
    public ISendVoiceView mSendVoiceView;
    public TextView mTexGroup;
    public String mTextContent;
    public TextView mTextNewMsg;
    public EditorTools mTool;
    public View personal_lbs_shadow;
    public TextView personal_lbs_title_lbsinfo;
    public TextView personal_lbs_title_name;
    public TextView personal_lbs_title_time;
    public View personalchat_lbs_title;

    /* loaded from: classes4.dex */
    public static class DraftContent extends OrmObject implements Serializable {
        public String input_draft;
        public String input_status;

        public String getInput_draft() {
            return this.input_draft;
        }

        public String getInput_status() {
            return this.input_status;
        }

        public void setInput_draft(String str) {
            this.input_draft = str;
        }

        public void setInput_status(String str) {
            this.input_status = str;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.w.b {
        public a() {
        }

        @Override // d.a.m0.w.b
        public void onAction(d.a.m0.w.a aVar) {
            if (aVar == null) {
                return;
            }
            int i2 = aVar.f50841a;
            if (i2 == 24) {
                Object obj = aVar.f50843c;
                if (obj == null || !(obj instanceof v)) {
                    return;
                }
                v vVar = (v) obj;
                EmotionGroupType f2 = vVar.f();
                String c2 = vVar.c();
                if (f2 == EmotionGroupType.LOCAL || c2 == null) {
                    return;
                }
                AbsMsglistView.this.mContext.sendBigEmotionMsg(vVar);
                AbsMsglistView.this.onSendEmotion();
            } else if (i2 == 8) {
                AbsMsglistView.this.mContext.sendTextMsg();
            } else if (i2 != 4) {
                if (i2 == 14) {
                    AbsMsglistView.this.mContext.openImageView();
                }
            } else {
                Object obj2 = aVar.f50843c;
                if (obj2 == null || !(obj2 instanceof String)) {
                    return;
                }
                AbsMsglistView.this.mTextContent = (String) obj2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            AbsMsglistView.this.mHandler.removeMessages(1);
            AbsMsglistView.this.closeRecordCancel();
            AbsMsglistView.this.closeRecordTooShort();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AbsListView.OnScrollListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsglistActivity f16962e;

        public c(MsglistActivity msglistActivity) {
            this.f16962e = msglistActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            l.x(this.f16962e.getActivity(), this.f16962e.getActivity().getCurrentFocus());
            EditorTools editorTools = AbsMsglistView.this.mTool;
            if (editorTools != null) {
                editorTools.q();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MsglistActivity f16964e;

        public d(MsglistActivity msglistActivity) {
            this.f16964e = msglistActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            l.x(this.f16964e.getActivity(), this.f16964e.getActivity().getCurrentFocus());
            EditorTools editorTools = AbsMsglistView.this.mTool;
            if (editorTools != null) {
                editorTools.q();
            }
            AbsMsglistView.this.MainOnTouch();
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AbsListView.RecyclerListener {
        public e(AbsMsglistView absMsglistView) {
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            View findViewById = view.findViewById(R.id.lay_msgitem_voice);
            if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
                ((ChatVoiceView) findViewById).e();
            }
            View findViewById2 = view.findViewById(R.id.emotion_msgitem_image);
            if (findViewById2 == null || !(findViewById2 instanceof GifView)) {
                return;
            }
            ((GifView) findViewById2).y0();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();

        void b(VoiceData$VoiceModel voiceData$VoiceModel);
    }

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
        this.mActionListener = new a();
        this.mSendTool = null;
        this.mSendVoiceView = null;
        this.mLayNewMsg = null;
        this.mTextNewMsg = null;
        this.mContext = null;
        this.mMsgItemOperation = null;
        this.mLayBottom = null;
        this.mHandler = new b();
        this.mNeedShowName = true;
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

    public void MainOnTouch() {
    }

    public void addAt2SendMsg(String str) {
        if (TextUtils.isEmpty(this.mTextContent)) {
            this.mTextContent = "@" + str + " ";
        } else {
            this.mTextContent += CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + str + " ";
        }
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.A(new d.a.m0.w.a(6, 3, this.mTextContent));
        }
    }

    public void afterSendMsgText() {
        this.mTextContent = null;
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.A(new d.a.m0.w.a(9, -1, Boolean.TRUE));
        }
    }

    public String beforeSendMsgText() {
        if (TextUtils.isEmpty(this.mTextContent)) {
            return null;
        }
        return this.mTextContent;
    }

    public void bindDataAndRefresh(MsgPageData msgPageData, long j) {
        if (msgPageData == null) {
            return;
        }
        this.mAdapter.j(msgPageData.getChatMessages());
        this.mAdapter.h();
    }

    public final boolean checkListAtNew(int i2) {
        List<ChatMessage> c2 = this.mAdapter.c();
        if (c2 == null) {
            return false;
        }
        if (c2.size() <= i2) {
            return true;
        }
        return this.mLisMsg.getLastVisiblePosition() == (c2.size() - getOffset()) - i2;
    }

    public void closeNewMsg() {
        if (this.mLayNewMsg.getVisibility() == 0) {
            this.mLayNewMsg.setVisibility(8);
            this.mTextNewMsg.setText("");
        }
    }

    public void closeNotNotify() {
        this.mNotNotify.setVisibility(8);
    }

    public void closeProgress() {
        this.mPrgLisMsg.setVisibility(8);
    }

    public void closeReceiver() {
        this.mReceiver.setVisibility(8);
    }

    public void closeRecordCancel() {
        if (this.mSendVoiceView == null || !getPageContext().getOrignalPage().grantWindowPermission(null)) {
            return;
        }
        this.mSendVoiceView.closeRecordCancel();
    }

    public void closeRecordTooShort() {
        if (this.mSendVoiceView == null || !getPageContext().getOrignalPage().grantWindowPermission(null)) {
            return;
        }
        this.mSendVoiceView.closeRecordTooShort();
    }

    public void displayNoNetwork() {
        this.mNetworkView.e(true);
    }

    public final void doRefresh(MsgPageData msgPageData, int i2) {
        if (msgPageData == null) {
            return;
        }
        try {
            this.mAdapter.j(msgPageData.getChatMessages());
            this.mAdapter.g();
            if (i2 >= 0) {
                this.mLisMsg.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public d.a.n0.f1.f.f getAdapter() {
        return this.mAdapter;
    }

    public View getBtnBack() {
        return this.mImgBack;
    }

    public View getBtnGroupInfo() {
        return this.mBtnGroupInfo;
    }

    public View getBtnSendVoice() {
        ISendVoiceView iSendVoiceView = this.mSendVoiceView;
        if (iSendVoiceView == null || !(iSendVoiceView instanceof View)) {
            return null;
        }
        return (View) iSendVoiceView;
    }

    public final String getContent(ChatMessage chatMessage) {
        return d.a.n0.f1.w.c.c(chatMessage);
    }

    public String getDraft() {
        n nVar;
        EditorTools editorTools = this.mTool;
        if (editorTools == null) {
            return "";
        }
        m n = editorTools.n(3);
        String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
        if (n != null && (nVar = n.k) != null && (nVar instanceof View) && ((View) nVar).getVisibility() != 0) {
            str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.mTextContent);
        hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
        return OrmObject.jsonStrWithObject((DraftContent) OrmObject.objectWithMap(hashMap, DraftContent.class));
    }

    public LinearLayout getLayNewMsg() {
        return this.mLayNewMsg;
    }

    public ViewGroup getLayoutBottom() {
        return this.mLayBottom;
    }

    public FrameLayout getListMain() {
        return this.mListMain;
    }

    public j getMsgItemOperationDialog() {
        return this.mMsgItemOperation;
    }

    public BdTypeListView getMsgListView() {
        return this.mLisMsg;
    }

    public int getOffset() {
        return 1;
    }

    public void hideMore() {
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.q();
        }
    }

    public void hideNoNetwork() {
        this.mNetworkView.e(false);
    }

    public void initBottom(TalkableActivity talkableActivity) {
        this.mLayBottom = (ViewGroup) talkableActivity.findViewById(R.id.lay_bottom_bar);
    }

    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
        this.mNavigationBar = navigationBar;
        this.mImgBack = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
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

    public void initMsgSend(TalkableActivity talkableActivity) {
        EditorTools editorTools = new EditorTools(talkableActivity.getActivity());
        this.mTool = editorTools;
        editorTools.setIsIM(true);
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setBackgroundColorId(R.color.CAM_X0204);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            m mVar = (m) runTask.getData();
            this.mSendTool = mVar;
            n nVar = mVar.k;
            if (nVar != null && (nVar instanceof ISendVoiceView)) {
                ISendVoiceView iSendVoiceView = (ISendVoiceView) nVar;
                this.mSendVoiceView = iSendVoiceView;
                if (iSendVoiceView instanceof View) {
                    ((View) iSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            m mVar2 = this.mSendTool;
            mVar2.j = 1;
            this.mTool.d(mVar2);
        }
        this.mTool.d(new d.a.m0.w.r.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mTool.h(arrayList);
        m n = this.mTool.n(5);
        if (n != null) {
            n.f(false);
            n.j = 3;
        }
        d.a.m0.w.s.a aVar = new d.a.m0.w.s.a(talkableActivity.getActivity(), false, false);
        aVar.h(true);
        n nVar2 = aVar.k;
        if (nVar2 != null && (nVar2 instanceof EditText)) {
            ((EditText) nVar2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds36));
        }
        this.mTool.d(aVar);
        d.a.m0.w.x.a aVar2 = new d.a.m0.w.x.a(talkableActivity.getActivity());
        aVar2.g(R.string.send_msg);
        aVar2.h(R.color.CAM_X0302);
        this.mTool.d(aVar2);
        this.mTool.f();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.A(new d.a.m0.w.a(2, 5, "N"));
        }
    }

    public void initMsglist(MsglistActivity msglistActivity) {
        this.mListMain = (FrameLayout) msglistActivity.findViewById(R.id.layout_main);
        this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(R.id.lis_msg);
        ProgressBar progressBar = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
        this.mPrgLisMsg = progressBar;
        progressBar.setVisibility(8);
        this.mAdapter = new d.a.n0.f1.f.f(msglistActivity.getPageContext(), this.mLisMsg);
        setNeedShowName();
        this.mAdapter.l(this.mNeedShowName);
        this.mAdapter.k(isPersonal());
        this.mAdapter.m(msglistActivity);
        this.mAdapter.n(msglistActivity);
        this.mLisMsg.setOnScrollListener(new c(msglistActivity));
        this.mLisMsg.setOnSrollToTopListener(msglistActivity);
        this.mLisMsg.setOnSrollToBottomListener(msglistActivity);
        this.mLisMsg.setItemsCanFocus(true);
        this.mLisMsg.setFocusable(false);
        this.mLisMsg.setFocusableInTouchMode(false);
        this.mLisMsg.setClickable(false);
        this.mLisMsg.setOnTouchListener(new d(msglistActivity));
        this.mLisMsg.setKybdsScrollBottom(true);
        this.mLisMsg.setRecyclerListener(new e(this));
    }

    public final void initNewMsg(TalkableActivity talkableActivity) {
        this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(R.id.lay_last_msg);
        this.mTextNewMsg = (TextView) talkableActivity.findViewById(R.id.text_last_msg);
        this.mLayNewMsg.setOnClickListener(talkableActivity);
    }

    public final void initNoNetwork(TalkableActivity talkableActivity) {
        this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(R.id.view_no_network);
    }

    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
        this.mNavigationBar = navigationBar;
        this.mImgBack = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
        this.mBackImage = this.mNavigationBar.getBackImageView();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.personal_chat_lbs_title, (ViewGroup) null);
        this.personalchat_lbs_title = inflate;
        this.personal_lbs_title_name = (TextView) inflate.findViewById(R.id.personal_lbs_title_name);
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

    public boolean isMoreVisible() {
        EditorTools editorTools = this.mTool;
        if (editorTools == null) {
            return false;
        }
        return editorTools.u();
    }

    public abstract boolean isPersonal();

    public void onChangeSkinType(int i2) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setBackgroundColor(this.mListMain, R.color.CAM_X0204);
        TextView textView = this.personal_lbs_title_name;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        }
        TextView textView2 = this.personal_lbs_title_lbsinfo;
        if (textView2 != null) {
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
        }
        TextView textView3 = this.personal_lbs_title_time;
        if (textView3 != null) {
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
        }
        TextView textView4 = this.mTexGroup;
        if (textView4 != null) {
            SkinManager.setViewTextColor(textView4, R.color.CAM_X0105, 1);
        }
        this.mNetworkView.c(getPageContext(), i2);
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        ImageView imageView = this.mNotNotify;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.icon_chat_call_not);
        }
        this.mNavigationBar.onBackBtnOnChangeSkin();
    }

    @Override // d.a.c.e.q.f
    public void onDeletedVoice(String str) {
        f fVar = this.mCallback;
        if (fVar != null) {
            fVar.a();
        }
    }

    public void onDestory() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        d.a.n0.f1.f.f fVar = this.mAdapter;
        if (fVar != null) {
            fVar.i();
        }
    }

    public void onSendEmotion() {
    }

    @Override // d.a.c.e.q.f
    public void onSendVoice(String str, int i2) {
        VoiceData$VoiceModel voiceData$VoiceModel = new VoiceData$VoiceModel();
        voiceData$VoiceModel.duration = i2;
        voiceData$VoiceModel.voiceId = str;
        voiceData$VoiceModel.voice_status = 1;
        f fVar = this.mCallback;
        if (fVar != null) {
            fVar.b(voiceData$VoiceModel);
        }
    }

    @Override // d.a.c.e.q.f
    public void onShowErr(int i2, String str) {
        if (this.mSendVoiceView != null && getPageContext().getOrignalPage().grantWindowPermission(null)) {
            this.mSendVoiceView.onShowErr(i2, str);
        }
        if (StringUtils.isNull(str)) {
            return;
        }
        if (i2 == 3) {
            this.mContext.showToast(str);
        } else if (i2 == 2) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
        } else {
            this.mContext.showToast(str);
        }
    }

    @Override // d.a.c.e.q.f
    public void onShowRecordTime(int i2) {
    }

    @Override // d.a.c.e.q.f
    public void onShowRecording(int i2) {
        ISendVoiceView iSendVoiceView = this.mSendVoiceView;
        if (iSendVoiceView != null) {
            iSendVoiceView.onShowRecording(i2);
        }
    }

    @Override // d.a.c.e.q.f
    public void onStartedRecorder(boolean z) {
    }

    @Override // d.a.c.e.q.f
    public void onStopingRecorder() {
    }

    public void refresh() {
        this.mAdapter.g();
    }

    public void refreshCheckNew(MsgPageData msgPageData) {
        if (msgPageData == null) {
            return;
        }
        try {
            if (msgPageData.getIsNewAdd() ? checkListAtNew(msgPageData.getNewAddNum()) : false) {
                refreshGo2New(msgPageData);
                return;
            }
            refreshNormal(msgPageData);
            if (msgPageData.getNewAddNum() <= 0 || msgPageData.getChatMessages() == null || msgPageData.getChatMessages().size() <= 0) {
                return;
            }
            showNewMsg(msgPageData.getChatMessages().get(msgPageData.getChatMessages().size() - 1));
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshGo2New(MsgPageData msgPageData) {
        if (msgPageData == null) {
            return;
        }
        try {
            removeMoreData(msgPageData);
            int size = msgPageData.getChatMessages().size();
            doRefresh(msgPageData, size > 0 ? size - 1 : 0);
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        this.mTexGroup.setText(StringHelper.getFixedText(str, 8, true));
    }

    public void refreshNormal(MsgPageData msgPageData) {
        doRefresh(msgPageData, -1);
    }

    public void refreshPersonalHeadFooter(String str, d.a.m0.s.f.b bVar) {
        this.personal_lbs_title_name.setText(str);
        if (bVar == null) {
            return;
        }
        if (bVar.b() >= 0 && bVar.b() <= 1) {
            if (bVar.b() == 1) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(R.string.contact_yinshen));
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
                return;
            } else if (!StringUtils.isNull(bVar.a()) && bVar.c() > 0) {
                this.personal_lbs_title_lbsinfo.setVisibility(0);
                this.personal_lbs_shadow.setVisibility(0);
                this.personal_lbs_title_time.setVisibility(0);
                this.personal_lbs_title_time.setText(StringHelper.getTimeInterval(bVar.c()));
                this.personal_lbs_title_lbsinfo.setText(bVar.a());
                return;
            } else {
                this.personal_lbs_title_lbsinfo.setVisibility(8);
                this.personal_lbs_shadow.setVisibility(8);
                this.personal_lbs_title_time.setVisibility(8);
                return;
            }
        }
        this.personal_lbs_title_lbsinfo.setVisibility(8);
    }

    public void refreshPrepage(MsgPageData msgPageData) {
        try {
            int firstVisiblePosition = this.mLisMsg.getFirstVisiblePosition();
            if (msgPageData.getIsNewAdd()) {
                doRefresh(msgPageData, firstVisiblePosition + msgPageData.getNewAddNum());
            } else {
                doRefresh(msgPageData, -1);
            }
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshSendVoiceText(boolean z) {
        ISendVoiceView iSendVoiceView = this.mSendVoiceView;
        if (iSendVoiceView != null) {
            iSendVoiceView.refreshSendVoiceText(z);
        }
    }

    public final void removeMoreData(MsgPageData msgPageData) {
        int size;
        if (msgPageData == null || msgPageData.getChatMessages() == null || msgPageData.getChatMessages().size() == 0 || (size = msgPageData.getChatMessages().size()) <= 100) {
            return;
        }
        int i2 = size - 100;
        for (int i3 = 0; i3 < i2; i3++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public void sendmsgCloseSoftkey() {
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.q();
        }
        l.x(this.mContext.getActivity(), this.mContext.getCurrentFocus());
    }

    public void setDraft(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.mTool != null) {
                this.mTool.A(new d.a.m0.w.a(6, 3, string));
            }
            this.mTextContent = string;
            if (!jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) || this.mTool == null) {
                return;
            }
            this.mTool.A(new d.a.m0.w.a(1, 6, null));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public abstract void setNeedShowName();

    public void setRecordCallback(f fVar) {
        this.mCallback = fVar;
    }

    public void showDiaItemContentOperate(int i2, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        j jVar = new j(this.mContext.getPageContext());
        jVar.i(null, strArr, this.mContext);
        this.mMsgItemOperation = jVar;
        jVar.f().setTag(Integer.valueOf(i2));
        this.mMsgItemOperation.l();
    }

    public final void showNewMsg(ChatMessage chatMessage) {
        if (chatMessage == null || d.a.n0.f1.w.c.p(chatMessage)) {
            return;
        }
        String content = getContent(chatMessage);
        if (TextUtils.isEmpty(content)) {
            return;
        }
        this.mLayNewMsg.setVisibility(0);
        this.mTextNewMsg.setText(content);
    }

    public void showNotNotfiy() {
        this.mNotNotify.setVisibility(0);
    }

    public void showReceiver() {
        this.mReceiver.setVisibility(0);
    }

    public void showRecordCancel() {
        if (this.mSendVoiceView == null || !getPageContext().getOrignalPage().grantWindowPermission(null)) {
            return;
        }
        this.mSendVoiceView.showRecordCancel();
    }

    public void startRecordVoice() {
        if (this.mSendVoiceView == null || !getPageContext().getOrignalPage().grantWindowPermission(null)) {
            return;
        }
        this.mSendVoiceView.startRecordVoice();
    }

    public void stopRecordVoice() {
        if (this.mSendVoiceView == null || !getPageContext().getOrignalPage().grantWindowPermission(null)) {
            return;
        }
        this.mSendVoiceView.stopRecordVoice();
    }

    public void updateAdapter(int i2, ChatMessage chatMessage) {
        chatMessage.setProgressValue(i2);
        this.mAdapter.f(chatMessage);
    }
}
