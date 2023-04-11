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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.BottomInputLayout;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ad5;
import com.baidu.tieba.bd5;
import com.baidu.tieba.e28;
import com.baidu.tieba.e85;
import com.baidu.tieba.fd5;
import com.baidu.tieba.g28;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.PersonalFollowTipLayout;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.l05;
import com.baidu.tieba.md5;
import com.baidu.tieba.nx7;
import com.baidu.tieba.pc5;
import com.baidu.tieba.q25;
import com.baidu.tieba.qc5;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vz7;
import com.baidu.tieba.wi;
import com.baidu.tieba.y8;
import com.baidu.tieba.yi;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.CoroutineContextKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class AbsMsglistView extends y8<MsglistActivity<?>> implements yi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalFollowTipLayout followTipLayout;
    public qc5 mActionListener;
    public nx7 mAdapter;
    public View mBtnForumInfo;
    public i mCallback;
    public MsglistActivity mContext;
    public final Handler mHandler;
    public View mImgBack;
    public RelativeLayout mInputControl;
    public md5 mInputTool;
    public boolean mIsPersonalHeader;
    public ViewGroup mLayBottom;
    public LinearLayout mLayNewMsg;
    public BdTypeListView mLisMsg;
    public FrameLayout mListMain;
    public l05 mMsgItemOperation;
    public View mMsgListBgView;
    public View mMsgListBgViewMask;
    public NavigationBar mNavigationBar;
    public View mNavigationBarBgView;
    public boolean mNeedShowName;
    public NoNetworkView mNetworkView;
    public ImageView mNotNotify;
    public ProgressBar mPrgLisMsg;
    public ImageView mReceiver;
    public KeyboardLayout mRootView;
    public ad5 mSendTool;
    public ISendVoiceView mSendVoiceView;
    public TextView mTexGroup;
    public String mTextContent;
    public TextView mTextNewMsg;
    public EditorTools mTool;
    public j mUpdateListener;
    public RoundRelativeLayout originListContainer;
    public View personal_lbs_shadow;
    public TextView personal_lbs_title_lbsinfo;
    public TextView personal_lbs_title_name;
    public TextView personal_lbs_title_time;
    public View personalchat_lbs_title;
    public View transparentView;
    public LinearLayout viewHeader;

    /* loaded from: classes4.dex */
    public interface i {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(ArrayList<ReportPrivateMsgData> arrayList, boolean z);
    }

    public void MainOnTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public int getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract boolean isFromReport();

    public abstract boolean isPersonal();

    public void onSendEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    public abstract ArrayList<ReportPrivateMsgData> selectList();

    public abstract void setNeedShowName();

    /* loaded from: classes4.dex */
    public static class DraftContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String input_draft;
        public String input_status;

        public DraftContent() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String getInput_draft() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.input_draft;
            }
            return (String) invokeV.objValue;
        }

        public String getInput_status() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.input_status;
            }
            return (String) invokeV.objValue;
        }

        public void setInput_draft(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.input_draft = str;
            }
        }

        public void setInput_status(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.input_status = str;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements qc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsglistView a;

        public a(AbsMsglistView absMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsglistView;
        }

        @Override // com.baidu.tieba.qc5
        public void C(pc5 pc5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, pc5Var) != null) || pc5Var == null) {
                return;
            }
            int i = pc5Var.a;
            if (i == 24) {
                Object obj = pc5Var.c;
                if (obj != null && (obj instanceof e85)) {
                    e85 e85Var = (e85) obj;
                    EmotionGroupType type = e85Var.getType();
                    String d = e85Var.d();
                    if (type != EmotionGroupType.LOCAL && d != null) {
                        this.a.mContext.P1(e85Var);
                        this.a.onSendEmotion();
                    }
                }
            } else if (i == 8) {
                this.a.mContext.Q1();
            } else if (i == 4) {
                Object obj2 = pc5Var.c;
                if (obj2 != null && (obj2 instanceof String)) {
                    this.a.mTextContent = (String) obj2;
                }
            } else if (i == 14) {
                this.a.mContext.I1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsglistView a;

        public b(AbsMsglistView absMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsglistView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.mHandler.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsglistActivity a;
        public final /* synthetic */ AbsMsglistView b;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        public c(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView, msglistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absMsglistView;
            this.a = msglistActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                ii.z(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                EditorTools editorTools = this.b.mTool;
                if (editorTools != null) {
                    editorTools.s();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsglistActivity a;
        public final /* synthetic */ AbsMsglistView b;

        public d(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView, msglistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absMsglistView;
            this.a = msglistActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                ii.z(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                EditorTools editorTools = this.b.mTool;
                if (editorTools != null) {
                    editorTools.s();
                }
                this.b.MainOnTouch();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements KeyboardLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsMsglistView a;

        public e(AbsMsglistView absMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absMsglistView;
        }

        @Override // com.baidu.tbadk.widget.KeyboardLayout.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != -3) {
                    if (i == -2) {
                        this.a.transparentView.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.a.transparentView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsglistActivity a;

        public f(AbsMsglistView absMsglistView, MsglistActivity msglistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView, msglistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msglistActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                ii.z(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AbsListView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(AbsMsglistView absMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View findViewById = view2.findViewById(R.id.lay_msgitem_voice);
                if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
                    ((ChatVoiceView) findViewById).l();
                }
                View findViewById2 = view2.findViewById(R.id.emotion_msgitem_image);
                if (findViewById2 != null && (findViewById2 instanceof GifView)) {
                    ((GifView) findViewById2).n0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(AbsMsglistView absMsglistView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absMsglistView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vz7.a(view2.getContext());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mNavigationBar = null;
        this.mNavigationBarBgView = null;
        this.mImgBack = null;
        this.mMsgListBgView = null;
        this.mMsgListBgViewMask = null;
        this.mTexGroup = null;
        this.mBtnForumInfo = null;
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
        this.mIsPersonalHeader = false;
        this.mTool = null;
        this.mTextContent = null;
        this.mInputTool = null;
        this.mActionListener = new a(this);
        this.mSendTool = null;
        this.mSendVoiceView = null;
        this.mLayNewMsg = null;
        this.mTextNewMsg = null;
        this.mContext = null;
        this.mMsgItemOperation = null;
        this.mLayBottom = null;
        this.mHandler = new b(this);
        this.mNeedShowName = true;
        this.mRootView = null;
        this.mContext = msglistActivity;
        msglistActivity.setContentView(R.layout.msg_msglist_activity);
        this.mRootView = (KeyboardLayout) msglistActivity.findViewById(R.id.msg_root_view);
        initHeader(msglistActivity, z);
        initHeaderTip(msglistActivity);
        initMsglist(msglistActivity);
        initMsgSend(msglistActivity);
        initNewMsg(msglistActivity);
        initBottom(msglistActivity);
        initOriginContainer();
    }

    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048614, this, talkableActivity, z) == null) {
            this.mIsPersonalHeader = true;
            NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
            this.mNavigationBar = navigationBar;
            this.mNavigationBarBgView = navigationBar.getBarBgView();
            this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.personal_chat_lbs_title, (ViewGroup) null);
            this.personalchat_lbs_title = inflate;
            this.personal_lbs_title_name = (TextView) inflate.findViewById(R.id.personal_lbs_title_name);
            this.personal_lbs_title_lbsinfo = (TextView) this.personalchat_lbs_title.findViewById(R.id.personal_lbs_title_lbsinfo);
            this.personal_lbs_title_time = (TextView) this.personalchat_lbs_title.findViewById(R.id.personal_lbs_title_time);
            this.mNotNotify = (ImageView) this.personalchat_lbs_title.findViewById(R.id.img_close_notify);
            this.personal_lbs_shadow = this.personalchat_lbs_title.findViewById(R.id.personal_lbs_shadow);
            this.mNavigationBar.setTitleView(this.personalchat_lbs_title, null, NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER);
            this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.msg_chat_ear_item, (View.OnClickListener) null);
            this.mInputControl = (RelativeLayout) talkableActivity.findViewById(R.id.layout_bottom_input);
            if (z) {
                closeNotNotify();
            } else {
                showNotNotfiy();
            }
        }
    }

    public void refreshPersonalHeadFooter(String str, aa5 aa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, str, aa5Var) == null) {
            this.personal_lbs_title_name.setText(str);
            if (aa5Var == null) {
                return;
            }
            if (aa5Var.b() >= 0 && aa5Var.b() <= 1) {
                if (aa5Var.b() == 1) {
                    this.personal_lbs_title_lbsinfo.setVisibility(0);
                    this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(R.string.contact_yinshen));
                    this.personal_lbs_shadow.setVisibility(8);
                    this.personal_lbs_title_time.setVisibility(8);
                    return;
                } else if (!StringUtils.isNull(aa5Var.a()) && aa5Var.c() > 0) {
                    this.personal_lbs_title_lbsinfo.setVisibility(0);
                    this.personal_lbs_shadow.setVisibility(0);
                    this.personal_lbs_title_time.setVisibility(0);
                    this.personal_lbs_title_time.setText(StringHelper.getTimeInterval(aa5Var.c()));
                    this.personal_lbs_title_lbsinfo.setText(aa5Var.a());
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
    }

    @Override // com.baidu.tieba.yi
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, str, i2) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.duration = i2;
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            i iVar = this.mCallback;
            if (iVar != null) {
                iVar.b(voiceModel);
            }
        }
    }

    @Override // com.baidu.tieba.yi
    public void onStartedRecorder(boolean z, int i2) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.onStartedRecorder(z, wi.b);
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, str, z) == null) {
            this.mTexGroup.setText(StringHelper.getFixedText(str, 8, true));
        }
    }

    public void updateAdapterProgress(int i2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048651, this, i2, chatMessage) == null) {
            chatMessage.setProgressValue(i2);
            this.mAdapter.i(chatMessage);
        }
    }

    public final String getContent(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatMessage)) == null) {
            return e28.g(chatMessage);
        }
        return (String) invokeL.objValue;
    }

    public void hideFollowTip(boolean z) {
        PersonalFollowTipLayout personalFollowTipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (personalFollowTipLayout = this.followTipLayout) != null) {
            personalFollowTipLayout.c(z);
        }
    }

    public void initBottom(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, talkableActivity) == null) {
            this.mLayBottom = (ViewGroup) talkableActivity.findViewById(R.id.lay_bottom_bar);
        }
    }

    public void initFollowTip(UserData userData) {
        PersonalFollowTipLayout personalFollowTipLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, userData) != null) || (personalFollowTipLayout = this.followTipLayout) == null) {
            return;
        }
        if (userData == null) {
            hideFollowTip(false);
        } else {
            personalFollowTipLayout.e(userData);
        }
    }

    public final void initNewMsg(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, talkableActivity) == null) {
            this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(R.id.lay_last_msg);
            this.mTextNewMsg = (TextView) talkableActivity.findViewById(R.id.text_last_msg);
            this.mLayNewMsg.setOnClickListener(talkableActivity);
        }
    }

    @Override // com.baidu.tieba.yi
    public void onDeletedVoice(String str) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, str) == null) && (iVar = this.mCallback) != null) {
            iVar.a();
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowRecordTime(int i2) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.onShowRecordTime(i2);
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowRecording(int i2) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048626, this, i2) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.onShowRecording(i2);
        }
    }

    public void refreshGo2New(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, msgPageData) != null) || msgPageData == null) {
            return;
        }
        try {
            removeMoreData(msgPageData);
            int size = msgPageData.size();
            int i2 = 0;
            if (size > 0) {
                i2 = size - 1;
            }
            doRefresh(msgPageData, i2);
            setSelectionFocusDown();
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshNormal(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, msgPageData) == null) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshNormalWithSelection(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, msgPageData) == null) && msgPageData != null) {
            doRefresh(msgPageData, msgPageData.size() - 1);
        }
    }

    public void refreshPrepage(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, msgPageData) == null) {
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
    }

    public void setRecoding(boolean z) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048641, this, z) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.setRecoding(z);
        }
    }

    public void setRecordCallback(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, iVar) == null) {
            this.mCallback = iVar;
        }
    }

    public void setUpdateListener(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, jVar) == null) {
            this.mUpdateListener = jVar;
        }
    }

    public void setVoiceTouchCallback(g28 g28Var) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048645, this, g28Var) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.setTouchCallBack(g28Var);
        }
    }

    public final void showNewMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048648, this, chatMessage) != null) || chatMessage == null || e28.w(chatMessage)) {
            return;
        }
        String content = getContent(chatMessage);
        if (TextUtils.isEmpty(content)) {
            return;
        }
        this.mLayNewMsg.setVisibility(0);
        this.mTextNewMsg.setText(content);
    }

    public void addAt2SendMsg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(this.mTextContent)) {
                this.mTextContent = "@" + str + " ";
            } else {
                this.mTextContent += CoroutineContextKt.DEBUG_THREAD_NAME_SEPARATOR + str + " ";
            }
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.C(new pc5(6, 3, this.mTextContent));
            }
        }
    }

    public void refreshCheckNew(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, msgPageData) != null) || msgPageData == null) {
            return;
        }
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
            if (msgPageData.getNewAddNum() > 0 && msgPageData.getChatMessages() != null && msgPageData.size() > 0) {
                showNewMsg(msgPageData.getChatMessages().get(msgPageData.size() - 1));
            }
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void setDraft(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.mTool != null) {
                this.mTool.C(new pc5(6, 3, string));
            }
            this.mTextContent = string;
            if (jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) && this.mTool != null) {
                this.mTool.C(new pc5(1, 6, null));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void afterSendMsgText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTextContent = null;
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.C(new pc5(9, -1, Boolean.TRUE));
            }
        }
    }

    public String beforeSendMsgText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.mTextContent)) {
                return null;
            }
            return this.mTextContent;
        }
        return (String) invokeV.objValue;
    }

    public void closeNewMsg() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mLayNewMsg.getVisibility() == 0) {
            this.mLayNewMsg.setVisibility(8);
            this.mTextNewMsg.setText("");
        }
    }

    public void closeNotNotify() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mNotNotify.setVisibility(8);
        }
    }

    public void closeProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mPrgLisMsg.setVisibility(8);
        }
    }

    public void closeReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mReceiver.setVisibility(8);
        }
    }

    public void closeTitleView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.personalchat_lbs_title.setVisibility(8);
        }
    }

    public void displayNoNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mNetworkView.update(true);
        }
    }

    public nx7 getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mAdapter;
        }
        return (nx7) invokeV.objValue;
    }

    public View getBtnBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mImgBack;
        }
        return (View) invokeV.objValue;
    }

    public View getBtnGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mBtnForumInfo;
        }
        return (View) invokeV.objValue;
    }

    public View getBtnSendVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null && (iSendVoiceView instanceof View)) {
                return (View) iSendVoiceView;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public LinearLayout getLayNewMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mLayNewMsg;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public ViewGroup getLayoutBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mLayBottom;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public FrameLayout getListMain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mListMain;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public l05 getMsgItemOperationDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mMsgItemOperation;
        }
        return (l05) invokeV.objValue;
    }

    public BdTypeListView getMsgListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mLisMsg;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.mRootView.getChildAt(2).getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void hideInputControlTouchInterceptView() {
        RelativeLayout relativeLayout;
        View findViewById;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (relativeLayout = this.mInputControl) != null && (findViewById = relativeLayout.findViewById(R.id.input_tool_block_view)) != null) {
            this.mInputControl.removeView(findViewById);
        }
    }

    public void hideMore() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (editorTools = this.mTool) != null) {
            editorTools.s();
        }
    }

    public void hideNoNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mNetworkView.update(false);
        }
    }

    public final void initOriginContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.mRootView.findViewById(R.id.origin_list_container);
            this.originListContainer = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(0.0f);
        }
    }

    public boolean isMoreVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools == null) {
                return false;
            }
            return editorTools.w();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yi
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                return iSendVoiceView.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
            }
            nx7 nx7Var = this.mAdapter;
            if (nx7Var != null) {
                nx7Var.k();
            }
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                iSendVoiceView.t();
            }
        }
    }

    @Override // com.baidu.tieba.yi
    public void onStopingRecorder() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (iSendVoiceView = this.mSendVoiceView) != null) {
            iSendVoiceView.onStopingRecorder();
        }
    }

    public void sendmsgCloseSoftkey() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.s();
            }
            ii.z(this.mContext.getActivity(), this.mContext.getCurrentFocus());
        }
    }

    public void setSelectionFocusDown() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (bdTypeListView = this.mLisMsg) != null) {
            bdTypeListView.setSelection(130);
        }
    }

    public void showReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.mReceiver.setVisibility(0);
        }
    }

    public void bindDataAndRefresh(MsgPageData msgPageData, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048580, this, msgPageData, j2) != null) || msgPageData == null) {
            return;
        }
        this.mAdapter.l(msgPageData.getChatMessages());
        this.mAdapter.h();
        if (getLayoutBottom() instanceof BottomInputLayout) {
            ((BottomInputLayout) getLayoutBottom()).setHasPicData(this.mAdapter.d());
        }
    }

    public final void doRefresh(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048588, this, msgPageData, i2) != null) || msgPageData == null) {
            return;
        }
        try {
            this.mAdapter.l(msgPageData.getChatMessages());
            this.mAdapter.g();
            if (getLayoutBottom() instanceof BottomInputLayout) {
                ((BottomInputLayout) getLayoutBottom()).setHasPicData(this.mAdapter.d());
            }
            if (i2 >= 0) {
                this.mLisMsg.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.tieba.yi
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i2, str) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                iSendVoiceView.onShowErr(i2, str);
            }
            if (!StringUtils.isNull(str)) {
                if (i2 == 3) {
                    this.mContext.showToast(str);
                    this.mContext.R1(false);
                } else if (i2 == 2) {
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    this.mContext.showToast(str);
                }
            }
        }
    }

    public void showDiaItemContentOperate(int i2, String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048646, this, i2, strArr) == null) && strArr != null && strArr.length > 0) {
            l05 l05Var = new l05(this.mContext.getPageContext());
            l05Var.i(null, strArr, this.mContext);
            this.mMsgItemOperation = l05Var;
            l05Var.f().setTag(Integer.valueOf(i2));
            this.mMsgItemOperation.k();
        }
    }

    public final boolean checkListAtNew(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            List<ChatMessage> c2 = this.mAdapter.c();
            if (c2 == null) {
                return false;
            }
            if (c2.size() <= i2) {
                return true;
            }
            if (this.mLisMsg.getLastVisiblePosition() != (c2.size() - getOffset()) - i2) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void initHeaderTip(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, talkableActivity) == null) {
            this.viewHeader = (LinearLayout) talkableActivity.findViewById(R.id.view_header);
            this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(R.id.view_no_network);
            PersonalFollowTipLayout personalFollowTipLayout = (PersonalFollowTipLayout) talkableActivity.findViewById(R.id.person_follow_tip_layout);
            this.followTipLayout = personalFollowTipLayout;
            personalFollowTipLayout.f(getPageContext());
        }
    }

    public final void removeMoreData(MsgPageData msgPageData) {
        int size;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, msgPageData) == null) && msgPageData != null && msgPageData.getChatMessages() != null && msgPageData.size() != 0 && (size = msgPageData.size()) > 100) {
            int i2 = size - 100;
            for (int i3 = 0; i3 < i2; i3++) {
                msgPageData.getChatMessages().remove(0);
            }
        }
    }

    public String getDraft() {
        InterceptResult invokeV;
        bd5 bd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools == null) {
                return "";
            }
            ad5 p = editorTools.p(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (p != null && (bd5Var = p.m) != null && (bd5Var instanceof View) && ((View) bd5Var).getVisibility() != 0) {
                str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.mTextContent);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
            return OrmObject.jsonStrWithObject((DraftContent) OrmObject.objectWithMap(hashMap, DraftContent.class));
        }
        return (String) invokeV.objValue;
    }

    public void showInputControlTouchInterceptView() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (relativeLayout = this.mInputControl) != null && relativeLayout.findViewById(R.id.input_tool_block_view) == null) {
            View view2 = new View(this.mInputControl.getContext());
            view2.setOnClickListener(new h(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(6, R.id.input_tool_view);
            layoutParams.addRule(8, R.id.input_tool_view);
            view2.setId(R.id.input_tool_block_view);
            this.mInputControl.addView(view2, layoutParams);
        }
    }

    public void showNotNotfiy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (!this.mIsPersonalHeader) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTexGroup.getLayoutParams();
                layoutParams.rightMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                this.mTexGroup.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mNotNotify.getLayoutParams();
                layoutParams2.rightMargin = (ii.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070253) - ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds44)) - ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                this.mNotNotify.setLayoutParams(layoutParams2);
            }
            this.mNotNotify.setVisibility(0);
        }
    }

    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, talkableActivity, z) == null) {
            this.mIsPersonalHeader = false;
            NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.lay_title_bar);
            this.mNavigationBar = navigationBar;
            this.mNavigationBarBgView = navigationBar.getBarBgView();
            this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
            this.mTexGroup = this.mNavigationBar.setCenterTextTitle("");
            ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
            this.mNotNotify = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.icon_chat_call_not, R.color.CAM_X0105, null);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mNotNotify.getLayoutParams();
            layoutParams.width = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            layoutParams.height = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            this.mNotNotify.setLayoutParams(layoutParams);
            this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.msg_chat_ear_item, (View.OnClickListener) null);
            this.mInputControl = (RelativeLayout) talkableActivity.findViewById(R.id.layout_bottom_input);
            if (z) {
                closeNotNotify();
            } else {
                showNotNotfiy();
            }
        }
    }

    public void initMsgSend(TalkableActivity talkableActivity) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, talkableActivity) != null) || isFromReport()) {
            return;
        }
        MsglistActivity msglistActivity = this.mContext;
        if (msglistActivity != null) {
            z = msglistActivity.U1();
        } else {
            z = false;
        }
        EditorTools editorTools = new EditorTools(talkableActivity.getActivity());
        this.mTool = editorTools;
        editorTools.setBarLauncherType(7);
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setBackgroundColorId(R.color.CAM_X0204);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, ad5.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            ad5 ad5Var = (ad5) runTask.getData();
            this.mSendTool = ad5Var;
            bd5 bd5Var = ad5Var.m;
            if (bd5Var != null && (bd5Var instanceof ISendVoiceView)) {
                ISendVoiceView iSendVoiceView = (ISendVoiceView) bd5Var;
                this.mSendVoiceView = iSendVoiceView;
                if (iSendVoiceView instanceof View) {
                    ((View) iSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            ad5 ad5Var2 = this.mSendTool;
            ad5Var2.l = 1;
            this.mTool.d(ad5Var2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mTool.h(arrayList);
        ad5 p = this.mTool.p(5);
        if (p != null) {
            p.f(true);
            p.e(z);
            p.d = 0;
        }
        md5 md5Var = new md5(talkableActivity.getActivity(), true, false);
        this.mInputTool = md5Var;
        md5Var.j(true);
        this.mTool.d(this.mInputTool);
        this.mTool.d(new fd5(talkableActivity.getActivity()));
        this.mTool.d(new ze5(talkableActivity, z));
        this.mTool.f();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.mTool.setId(R.id.input_tool_view);
        this.mInputControl.addView(this.mTool, layoutParams);
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.C(new pc5(2, 5, "N"));
        }
        if (vz7.c()) {
            showInputControlTouchInterceptView();
        }
    }

    public void initMsglist(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, msglistActivity) == null) {
            this.mListMain = (FrameLayout) msglistActivity.findViewById(R.id.layout_main);
            this.mMsgListBgView = msglistActivity.findViewById(R.id.list_msg_bg_view);
            this.mMsgListBgViewMask = msglistActivity.findViewById(R.id.list_msg_bg_view_mask);
            this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(R.id.lis_msg);
            this.transparentView = msglistActivity.findViewById(R.id.transpant_view);
            ProgressBar progressBar = (ProgressBar) msglistActivity.findViewById(R.id.msg_progress);
            this.mPrgLisMsg = progressBar;
            progressBar.setVisibility(8);
            this.mAdapter = new nx7(msglistActivity.getPageContext(), this.mLisMsg);
            setNeedShowName();
            this.mAdapter.p(this.mNeedShowName);
            this.mAdapter.m(isFromReport());
            this.mAdapter.s(selectList());
            this.mAdapter.t(this.mUpdateListener);
            this.mAdapter.o(isPersonal());
            this.mAdapter.q(msglistActivity);
            this.mAdapter.r(msglistActivity);
            this.mLisMsg.setOnScrollListener(new c(this, msglistActivity));
            this.mLisMsg.setOnSrollToTopListener(msglistActivity);
            this.mLisMsg.setOnSrollToBottomListener(msglistActivity);
            this.mLisMsg.setItemsCanFocus(true);
            this.mLisMsg.setFocusable(false);
            this.mLisMsg.setFocusableInTouchMode(false);
            this.mLisMsg.setClickable(false);
            this.mLisMsg.setOnTouchListener(new d(this, msglistActivity));
            this.mRootView.setOnkbdStateListener(new e(this));
            this.transparentView.setOnTouchListener(new f(this, msglistActivity));
            this.mLisMsg.setKybdsScrollBottom(true);
            this.mLisMsg.setRecyclerListener(new g(this));
        }
    }

    public void onChangeSkinType(int i2) {
        bd5 bd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mNavigationBar.setBarBackgourndColor(R.color.CAM_X0204);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mListMain, R.color.CAM_X0204);
            q25.d(this.mNavigationBarBgView).q(new int[]{R.color.msg_navitation_bar_start, R.color.msg_navitation_bar_end}, Direction.LEFT);
            q25.d(this.mMsgListBgView).q(new int[]{R.color.msg_navitation_bar_start, R.color.msg_navitation_bar_end}, Direction.LEFT);
            q25.d(this.mMsgListBgViewMask).q(new int[]{R.color.msg_navitation_bar_mask_end, R.color.CAM_X0204}, Direction.TOP);
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
            nx7 nx7Var = this.mAdapter;
            if (nx7Var != null) {
                nx7Var.j(i2);
            }
            this.mNetworkView.d(getPageContext(), i2);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.y(i2);
            }
            ImageView imageView = this.mNotNotify;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_chat_call_not);
            }
            this.mNavigationBar.onBackBtnOnChangeSkin();
            md5 md5Var = this.mInputTool;
            if (md5Var != null && (bd5Var = md5Var.m) != null && (bd5Var instanceof EditText)) {
                q25 d2 = q25.d((EditText) bd5Var);
                d2.B(R.dimen.T_X06);
                d2.o(R.string.J_X07);
                d2.m(R.dimen.L_X01);
                d2.l(R.color.CAM_X0209);
                d2.f(R.color.CAM_X0212);
            }
            PersonalFollowTipLayout personalFollowTipLayout = this.followTipLayout;
            if (personalFollowTipLayout != null) {
                personalFollowTipLayout.h();
            }
        }
    }
}
