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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.RoundRelativeLayout;
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
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.d9;
import com.repackage.dy4;
import com.repackage.ej;
import com.repackage.fr4;
import com.repackage.g15;
import com.repackage.h05;
import com.repackage.i05;
import com.repackage.i87;
import com.repackage.k87;
import com.repackage.nw4;
import com.repackage.pi;
import com.repackage.r37;
import com.repackage.s25;
import com.repackage.t05;
import com.repackage.u05;
import com.repackage.wq4;
import com.repackage.y05;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.coroutines.CoroutineContextKt;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AbsMsglistView extends b9<MsglistActivity<?>> implements ej {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i05 mActionListener;
    public r37 mAdapter;
    public View mBtnGroupInfo;
    public h mCallback;
    public MsglistActivity mContext;
    public final Handler mHandler;
    public View mImgBack;
    public FrameLayout mInputControl;
    public g15 mInputTool;
    public boolean mIsPersonalHeader;
    public ViewGroup mLayBottom;
    public LinearLayout mLayNewMsg;
    public BdTypeListView mLisMsg;
    public FrameLayout mListMain;
    public wq4 mMsgItemOperation;
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
    public t05 mSendTool;
    public ISendVoiceView mSendVoiceView;
    public TextView mTexGroup;
    public String mTextContent;
    public TextView mTextNewMsg;
    public EditorTools mTool;
    public i mUpdateListener;
    public RoundRelativeLayout originListContainer;
    public View personal_lbs_shadow;
    public TextView personal_lbs_title_lbsinfo;
    public TextView personal_lbs_title_name;
    public TextView personal_lbs_title_time;
    public View personalchat_lbs_title;
    public View transparentView;
    public LinearLayout viewHeader;

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.input_draft : (String) invokeV.objValue;
        }

        public String getInput_status() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.input_status : (String) invokeV.objValue;
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

    /* loaded from: classes3.dex */
    public class a implements i05 {
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

        @Override // com.repackage.i05
        public void C(h05 h05Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) || h05Var == null) {
                return;
            }
            int i = h05Var.a;
            if (i == 24) {
                Object obj = h05Var.c;
                if (obj == null || !(obj instanceof nw4)) {
                    return;
                }
                nw4 nw4Var = (nw4) obj;
                EmotionGroupType type = nw4Var.getType();
                String d = nw4Var.d();
                if (type == EmotionGroupType.LOCAL || d == null) {
                    return;
                }
                this.a.mContext.T0(nw4Var);
                this.a.onSendEmotion();
            } else if (i == 8) {
                this.a.mContext.U0();
            } else if (i != 4) {
                if (i == 14) {
                    this.a.mContext.L0();
                }
            } else {
                Object obj2 = h05Var.c;
                if (obj2 == null || !(obj2 instanceof String)) {
                    return;
                }
                this.a.mTextContent = (String) obj2;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (message.what != 1) {
                    return;
                }
                this.a.mHandler.removeMessages(1);
                this.a.closeRecordCancel();
                this.a.closeRecordTooShort();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsglistActivity a;
        public final /* synthetic */ AbsMsglistView b;

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
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                pi.x(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                EditorTools editorTools = this.b.mTool;
                if (editorTools != null) {
                    editorTools.q();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                pi.x(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                EditorTools editorTools = this.b.mTool;
                if (editorTools != null) {
                    editorTools.q();
                }
                this.b.MainOnTouch();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                if (i == -3) {
                    this.a.transparentView.setVisibility(0);
                } else if (i != -2) {
                } else {
                    this.a.transparentView.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                pi.x(this.a.getActivity(), this.a.getActivity().getCurrentFocus());
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091174);
                if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
                    ((ChatVoiceView) findViewById).i();
                }
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f090875);
                if (findViewById2 == null || !(findViewById2 instanceof GifView)) {
                    return;
                }
                ((GifView) findViewById2).k0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(ArrayList<ReportPrivateMsgData> arrayList, boolean z);
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
                super((d9) newInitContext.callArgs[0]);
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
        msglistActivity.setContentView(R.layout.obfuscated_res_0x7f0d0543);
        this.mRootView = (KeyboardLayout) msglistActivity.findViewById(R.id.obfuscated_res_0x7f091425);
        initHeader(msglistActivity, z);
        initNoNetwork(msglistActivity);
        initMsglist(msglistActivity);
        initMsgSend(msglistActivity);
        initNewMsg(msglistActivity);
        initBottom(msglistActivity);
        initOriginContainer(msglistActivity);
    }

    public void MainOnTouch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
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
                editorTools.A(new h05(6, 3, this.mTextContent));
            }
        }
    }

    public void afterSendMsgText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTextContent = null;
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.A(new h05(9, -1, Boolean.TRUE));
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

    public void bindDataAndRefresh(MsgPageData msgPageData, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048580, this, msgPageData, j) == null) || msgPageData == null) {
            return;
        }
        this.mAdapter.k(msgPageData.getChatMessages());
        this.mAdapter.g();
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
            return this.mLisMsg.getLastVisiblePosition() == (c2.size() - getOffset()) - i2;
        }
        return invokeI.booleanValue;
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

    public void closeRecordCancel() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.closeRecordCancel();
    }

    public void closeRecordTooShort() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.closeRecordTooShort();
    }

    public void closeTitleView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.personalchat_lbs_title.setVisibility(8);
        }
    }

    public void displayNoNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mNetworkView.update(true);
        }
    }

    public final void doRefresh(MsgPageData msgPageData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, msgPageData, i2) == null) || msgPageData == null) {
            return;
        }
        try {
            this.mAdapter.k(msgPageData.getChatMessages());
            this.mAdapter.f();
            if (i2 >= 0) {
                this.mLisMsg.setSelection(i2);
            }
        } catch (Exception unused) {
        }
    }

    public r37 getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mAdapter : (r37) invokeV.objValue;
    }

    public View getBtnBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mImgBack : (View) invokeV.objValue;
    }

    public View getBtnGroupInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mBtnGroupInfo : (View) invokeV.objValue;
    }

    public View getBtnSendVoice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView == null || !(iSendVoiceView instanceof View)) {
                return null;
            }
            return (View) iSendVoiceView;
        }
        return (View) invokeV.objValue;
    }

    public final String getContent(ChatMessage chatMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, chatMessage)) == null) ? i87.e(chatMessage) : (String) invokeL.objValue;
    }

    public String getDraft() {
        InterceptResult invokeV;
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools == null) {
                return "";
            }
            t05 n = editorTools.n(3);
            String str = TbEnum.ChatInputStatus.INPUT_STATUS_TEXT;
            if (n != null && (u05Var = n.m) != null && (u05Var instanceof View) && ((View) u05Var).getVisibility() != 0) {
                str = TbEnum.ChatInputStatus.INPUT_STATUS_VOICE;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY, this.mTextContent);
            hashMap.put(TbEnum.ChatInputStatus.INPUT_STATUS_KEY, str);
            return OrmObject.jsonStrWithObject((DraftContent) OrmObject.objectWithMap(hashMap, DraftContent.class));
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout getLayNewMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mLayNewMsg : (LinearLayout) invokeV.objValue;
    }

    public ViewGroup getLayoutBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mLayBottom : (ViewGroup) invokeV.objValue;
    }

    public FrameLayout getListMain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mListMain : (FrameLayout) invokeV.objValue;
    }

    public wq4 getMsgItemOperationDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mMsgItemOperation : (wq4) invokeV.objValue;
    }

    public BdTypeListView getMsgListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mLisMsg : (BdTypeListView) invokeV.objValue;
    }

    public int getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean getVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mRootView.getChildAt(2).getVisibility() == 0 : invokeV.booleanValue;
    }

    public void hideMore() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (editorTools = this.mTool) == null) {
            return;
        }
        editorTools.q();
    }

    public void hideNoNetwork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mNetworkView.update(false);
        }
    }

    public void initBottom(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, talkableActivity) == null) {
            this.mLayBottom = (ViewGroup) talkableActivity.findViewById(R.id.obfuscated_res_0x7f09116b);
        }
    }

    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048607, this, talkableActivity, z) == null) {
            this.mIsPersonalHeader = false;
            NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091176);
            this.mNavigationBar = navigationBar;
            this.mNavigationBarBgView = navigationBar.getBarBgView();
            this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
            this.mTexGroup = this.mNavigationBar.setCenterTextTitle("");
            ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
            this.mNotNotify = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.icon_chat_call_not, R.color.CAM_X0105, null);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mNotNotify.getLayoutParams();
            layoutParams.width = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44);
            this.mNotNotify.setLayoutParams(layoutParams);
            this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d053d, (View.OnClickListener) null);
            this.mInputControl = (FrameLayout) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091183);
            if (z) {
                closeNotNotify();
            } else {
                showNotNotfiy();
            }
        }
    }

    public void initMsgSend(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, talkableActivity) == null) || isFromReport()) {
            return;
        }
        MsglistActivity msglistActivity = this.mContext;
        boolean b1 = msglistActivity != null ? msglistActivity.b1() : false;
        EditorTools editorTools = new EditorTools(talkableActivity.getActivity());
        this.mTool = editorTools;
        editorTools.setBarLauncherType(7);
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setBackgroundColorId(R.color.CAM_X0204);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, t05.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            t05 t05Var = (t05) runTask.getData();
            this.mSendTool = t05Var;
            u05 u05Var = t05Var.m;
            if (u05Var != null && (u05Var instanceof ISendVoiceView)) {
                ISendVoiceView iSendVoiceView = (ISendVoiceView) u05Var;
                this.mSendVoiceView = iSendVoiceView;
                if (iSendVoiceView instanceof View) {
                    ((View) iSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            t05 t05Var2 = this.mSendTool;
            t05Var2.l = 1;
            this.mTool.d(t05Var2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.mTool.h(arrayList);
        t05 n = this.mTool.n(5);
        if (n != null) {
            n.f(true);
            n.e(b1);
            n.d = 0;
        }
        g15 g15Var = new g15(talkableActivity.getActivity(), true, false);
        this.mInputTool = g15Var;
        g15Var.h(true);
        this.mTool.d(this.mInputTool);
        this.mTool.d(new y05(talkableActivity.getActivity()));
        this.mTool.d(new s25(talkableActivity, b1));
        this.mTool.f();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.A(new h05(2, 5, "N"));
        }
    }

    public void initMsglist(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, msglistActivity) == null) {
            this.mListMain = (FrameLayout) msglistActivity.findViewById(R.id.obfuscated_res_0x7f0911a4);
            this.mMsgListBgView = msglistActivity.findViewById(R.id.obfuscated_res_0x7f091238);
            this.mMsgListBgViewMask = msglistActivity.findViewById(R.id.obfuscated_res_0x7f091239);
            this.mLisMsg = (BdTypeListView) msglistActivity.findViewById(R.id.obfuscated_res_0x7f091230);
            this.transparentView = msglistActivity.findViewById(R.id.obfuscated_res_0x7f09212b);
            ProgressBar progressBar = (ProgressBar) msglistActivity.findViewById(R.id.obfuscated_res_0x7f091423);
            this.mPrgLisMsg = progressBar;
            progressBar.setVisibility(8);
            this.mAdapter = new r37(msglistActivity.getPageContext(), this.mLisMsg);
            setNeedShowName();
            this.mAdapter.o(this.mNeedShowName);
            this.mAdapter.l(isFromReport());
            this.mAdapter.r(selectList());
            this.mAdapter.s(this.mUpdateListener);
            this.mAdapter.n(isPersonal());
            this.mAdapter.p(msglistActivity);
            this.mAdapter.q(msglistActivity);
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

    public final void initNewMsg(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, talkableActivity) == null) {
            this.mLayNewMsg = (LinearLayout) talkableActivity.findViewById(R.id.obfuscated_res_0x7f09116f);
            this.mTextNewMsg = (TextView) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091f27);
            this.mLayNewMsg.setOnClickListener(talkableActivity);
        }
    }

    public final void initNoNetwork(TalkableActivity talkableActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, talkableActivity) == null) {
            this.viewHeader = (LinearLayout) talkableActivity.findViewById(R.id.obfuscated_res_0x7f092387);
            this.mNetworkView = (NoNetworkView) talkableActivity.findViewById(R.id.obfuscated_res_0x7f092391);
        }
    }

    public final void initOriginContainer(MsglistActivity msglistActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, msglistActivity) == null) {
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f0915d6);
            this.originListContainer = roundRelativeLayout;
            roundRelativeLayout.setPaintColor(0);
            this.originListContainer.setRadius(0.0f);
        }
    }

    public void initPersonalHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048613, this, talkableActivity, z) == null) {
            this.mIsPersonalHeader = true;
            NavigationBar navigationBar = (NavigationBar) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091176);
            this.mNavigationBar = navigationBar;
            this.mNavigationBarBgView = navigationBar.getBarBgView();
            this.mImgBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, talkableActivity);
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d06c8, (ViewGroup) null);
            this.personalchat_lbs_title = inflate;
            this.personal_lbs_title_name = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091803);
            this.personal_lbs_title_lbsinfo = (TextView) this.personalchat_lbs_title.findViewById(R.id.obfuscated_res_0x7f091802);
            this.personal_lbs_title_time = (TextView) this.personalchat_lbs_title.findViewById(R.id.obfuscated_res_0x7f091804);
            this.mNotNotify = (ImageView) this.personalchat_lbs_title.findViewById(R.id.obfuscated_res_0x7f090e69);
            this.personal_lbs_shadow = this.personalchat_lbs_title.findViewById(R.id.obfuscated_res_0x7f091801);
            this.mNavigationBar.setTitleView(this.personalchat_lbs_title, null, NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER);
            this.mReceiver = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d053d, (View.OnClickListener) null);
            this.mInputControl = (FrameLayout) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091183);
            if (z) {
                closeNotNotify();
            } else {
                showNotNotfiy();
            }
        }
    }

    public abstract boolean isFromReport();

    public boolean isMoreVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools == null) {
                return false;
            }
            return editorTools.u();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ej
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                return iSendVoiceView.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean isPersonal();

    public void onChangeSkinType(int i2) {
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mNavigationBar.setBarBackgourndColor(R.color.CAM_X0204);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mListMain, R.color.CAM_X0204);
            fr4.d(this.mNavigationBarBgView).p(new int[]{R.color.msg_navitation_bar_start, R.color.msg_navitation_bar_end}, Direction.LEFT);
            fr4.d(this.mMsgListBgView).p(new int[]{R.color.msg_navitation_bar_start, R.color.msg_navitation_bar_end}, Direction.LEFT);
            fr4.d(this.mMsgListBgViewMask).p(new int[]{R.color.msg_navitation_bar_mask_end, R.color.CAM_X0204}, Direction.TOP);
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
            r37 r37Var = this.mAdapter;
            if (r37Var != null) {
                r37Var.i(i2);
            }
            this.mNetworkView.d(getPageContext(), i2);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            ImageView imageView = this.mNotNotify;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_chat_call_not);
            }
            this.mNavigationBar.onBackBtnOnChangeSkin();
            g15 g15Var = this.mInputTool;
            if (g15Var == null || (u05Var = g15Var.m) == null || !(u05Var instanceof EditText)) {
                return;
            }
            fr4 d2 = fr4.d((EditText) u05Var);
            d2.z(R.dimen.T_X06);
            d2.n(R.string.J_X07);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0209);
            d2.f(R.color.CAM_X0212);
        }
    }

    @Override // com.repackage.ej
    public void onDeletedVoice(String str) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (hVar = this.mCallback) == null) {
            return;
        }
        hVar.a();
    }

    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
            }
            r37 r37Var = this.mAdapter;
            if (r37Var != null) {
                r37Var.j();
            }
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                iSendVoiceView.d();
            }
        }
    }

    public void onSendEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
        }
    }

    @Override // com.repackage.ej
    public void onSendVoice(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, str, i2) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.duration = i2;
            voiceModel.voiceId = str;
            voiceModel.voice_status = 1;
            h hVar = this.mCallback;
            if (hVar != null) {
                hVar.b(voiceModel);
            }
        }
    }

    @Override // com.repackage.ej
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048623, this, i2, str) == null) {
            ISendVoiceView iSendVoiceView = this.mSendVoiceView;
            if (iSendVoiceView != null) {
                iSendVoiceView.onShowErr(i2, str);
            }
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == 3) {
                this.mContext.showToast(str);
                this.mContext.W0(false);
            } else if (i2 == 2) {
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
            } else {
                this.mContext.showToast(str);
            }
        }
    }

    @Override // com.repackage.ej
    public void onShowRecordTime(int i2) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.onShowRecordTime(i2);
    }

    @Override // com.repackage.ej
    public void onShowRecording(int i2) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.onShowRecording(i2);
    }

    @Override // com.repackage.ej
    public void onStartedRecorder(boolean z) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.onStartedRecorder(z);
    }

    @Override // com.repackage.ej
    public void onStopingRecorder() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.onStopingRecorder();
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.mAdapter.f();
        }
    }

    public void refreshCheckNew(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            if (msgPageData.getIsNewAdd() ? checkListAtNew(msgPageData.getNewAddNum()) : false) {
                refreshGo2New(msgPageData);
                return;
            }
            refreshNormal(msgPageData);
            if (msgPageData.getNewAddNum() <= 0 || msgPageData.getChatMessages() == null || msgPageData.size() <= 0) {
                return;
            }
            showNewMsg(msgPageData.getChatMessages().get(msgPageData.size() - 1));
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshGo2New(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, msgPageData) == null) || msgPageData == null) {
            return;
        }
        try {
            removeMoreData(msgPageData);
            int size = msgPageData.size();
            doRefresh(msgPageData, size > 0 ? size - 1 : 0);
        } catch (Exception unused) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshHeaderFooter(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, str, z) == null) {
            this.mTexGroup.setText(StringHelper.getFixedText(str, 8, true));
        }
    }

    public void refreshNormal(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, msgPageData) == null) {
            doRefresh(msgPageData, -1);
        }
    }

    public void refreshPersonalHeadFooter(String str, dy4 dy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, str, dy4Var) == null) {
            this.personal_lbs_title_name.setText(str);
            if (dy4Var == null) {
                return;
            }
            if (dy4Var.b() >= 0 && dy4Var.b() <= 1) {
                if (dy4Var.b() == 1) {
                    this.personal_lbs_title_lbsinfo.setVisibility(0);
                    this.personal_lbs_title_lbsinfo.setText(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f042f));
                    this.personal_lbs_shadow.setVisibility(8);
                    this.personal_lbs_title_time.setVisibility(8);
                    return;
                } else if (!StringUtils.isNull(dy4Var.a()) && dy4Var.c() > 0) {
                    this.personal_lbs_title_lbsinfo.setVisibility(0);
                    this.personal_lbs_shadow.setVisibility(0);
                    this.personal_lbs_title_time.setVisibility(0);
                    this.personal_lbs_title_time.setText(StringHelper.getTimeInterval(dy4Var.c()));
                    this.personal_lbs_title_lbsinfo.setText(dy4Var.a());
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

    public void refreshPrepage(MsgPageData msgPageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, msgPageData) == null) {
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

    public final void removeMoreData(MsgPageData msgPageData) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, msgPageData) == null) || msgPageData == null || msgPageData.getChatMessages() == null || msgPageData.size() == 0 || (size = msgPageData.size()) <= 100) {
            return;
        }
        int i2 = size - 100;
        for (int i3 = 0; i3 < i2; i3++) {
            msgPageData.getChatMessages().remove(0);
        }
    }

    public abstract ArrayList<ReportPrivateMsgData> selectList();

    public void sendmsgCloseSoftkey() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.q();
            }
            pi.x(this.mContext.getActivity(), this.mContext.getCurrentFocus());
        }
    }

    public void setDraft(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(TbEnum.ChatInputStatus.INPUT_DRAFT_KEY);
            if (this.mTool != null) {
                this.mTool.A(new h05(6, 3, string));
            }
            this.mTextContent = string;
            if (!jSONObject.getString(TbEnum.ChatInputStatus.INPUT_STATUS_KEY).equals(TbEnum.ChatInputStatus.INPUT_STATUS_VOICE) || this.mTool == null) {
                return;
            }
            this.mTool.A(new h05(1, 6, null));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public abstract void setNeedShowName();

    public void setRecoding(boolean z) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048640, this, z) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.setRecoding(z);
    }

    public void setRecordCallback(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, hVar) == null) {
            this.mCallback = hVar;
        }
    }

    public void setUpdateListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, iVar) == null) {
            this.mUpdateListener = iVar;
        }
    }

    public void setVoiceTouchCallback(k87 k87Var) {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, k87Var) == null) || (iSendVoiceView = this.mSendVoiceView) == null) {
            return;
        }
        iSendVoiceView.setTouchCallBack(k87Var);
    }

    public void showDiaItemContentOperate(int i2, String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048644, this, i2, strArr) == null) || strArr == null || strArr.length <= 0) {
            return;
        }
        wq4 wq4Var = new wq4(this.mContext.getPageContext());
        wq4Var.j(null, strArr, this.mContext);
        this.mMsgItemOperation = wq4Var;
        wq4Var.f().setTag(Integer.valueOf(i2));
        this.mMsgItemOperation.m();
    }

    public final void showNewMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, chatMessage) == null) || chatMessage == null || i87.t(chatMessage)) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            if (!this.mIsPersonalHeader) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTexGroup.getLayoutParams();
                layoutParams.rightMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                this.mTexGroup.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mNotNotify.getLayoutParams();
                layoutParams2.rightMargin = (pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070253) - pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44)) - pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds3);
                this.mNotNotify.setLayoutParams(layoutParams2);
            }
            this.mNotNotify.setVisibility(0);
        }
    }

    public void showReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.mReceiver.setVisibility(0);
        }
    }

    public void updateAdapterProgress(int i2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048648, this, i2, chatMessage) == null) {
            chatMessage.setProgressValue(i2);
            this.mAdapter.h(chatMessage);
        }
    }
}
