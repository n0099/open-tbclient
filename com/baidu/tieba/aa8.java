package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.widget.GamePlayCardMsgView;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.sharecard.ChatShareCard;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.im.widget.sharecard.ChatShareCommonCard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class aa8 extends g9<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public static final String G;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public TbCheckBox B;
    public LinearLayout C;
    public AbsMsglistView.j D;
    public int E;
    public ChatMessage F;
    public ff b;
    public gf c;
    public long d;
    public Calendar e;
    public int f;
    public long g;
    public Long h;
    public TextView i;
    public TbRichTextView j;
    public ChatVoiceView k;
    public GifView l;
    public ShareFromPBView m;
    public ShareFromFrsView n;
    public ShareFromGameCenter o;
    public ChatImageWithTailView p;
    public ChatShareCard q;
    public GamePlayCardMsgView r;
    public ChatShareChatroomCard s;
    public ChatShareCommonCard t;
    public Boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public ArrayList<ReportPrivateMsgData> z;

    public void X(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view2, chatMessage) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public a(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 10, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public b(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 15, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public c(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 15, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public d(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 11, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public e(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 12, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public f(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 11, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ aa8 b;

        public g(aa8 aa8Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aa8Var;
            this.a = chatMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    if (this.b.z.size() < 20) {
                        this.b.B.setChecked(true);
                        this.b.z.add(new ReportPrivateMsgData(String.valueOf(this.a.getMsgId()), hka.b(this.b.mContext, this.a), String.valueOf(this.a.getTime())));
                        if (this.b.D != null) {
                            this.b.D.a(this.b.z, true);
                        }
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_REPORT_PRIVATE_MSG_CHANGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921670, Boolean.TRUE));
                    return;
                }
                int i = 0;
                this.b.B.setChecked(false);
                while (true) {
                    if (i < this.b.z.size()) {
                        if (this.b.z.get(i) != null && TextUtils.equals(String.valueOf(this.a.getMsgId()), this.b.z.get(i).getMsgId())) {
                            this.b.z.remove(i);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (this.b.D != null) {
                    this.b.D.a(this.b.z, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public h(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tbRichTextView = this.a.j) != null && tbRichTextView.getTextView() != null) {
                CharSequence text = this.a.j.getTextView().getText();
                if (!TextUtils.isEmpty(text)) {
                    if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                        if (text.toString().contains("http://") || text.toString().contains("https://")) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) l9.a(view2.getContext()), new String[]{aa8.G});
                            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public i(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 5, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public j(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 4, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public k(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 4, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public l(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 13, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public m(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 3, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public n(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 7, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public o(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                aa8 aa8Var = this.a;
                aa8Var.c.O(view2, 7, aa8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;

        public p(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                aa8Var.b.z(view2, 10, aa8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public q(aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947608561, "Lcom/baidu/tieba/aa8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947608561, "Lcom/baidu/tieba/aa8;");
                return;
            }
        }
        G = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa8(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
        super(tbPageContext, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BdPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.u = Boolean.FALSE;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = false;
        this.E = 3;
        this.d = 0L;
        this.e = null;
        this.mContext = tbPageContext;
    }

    public final void E(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) && chatMessage != null && chatMessage.getMsgType() == 2) {
            ax5.d();
        }
    }

    public final void H(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setVoice_status(1);
                chatMessage.setCacheData(msgCacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
        }
    }

    public final boolean J(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 < 1000) {
                return false;
            }
            long j3 = this.d;
            if (j3 != 0 && j2 - j3 < 180) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void M(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            calendar.setTimeInMillis(j2 * 1000);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.y = z;
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p.setVisibility(i2);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.w = z;
        }
    }

    public void S(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.d = j2;
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.v = z;
        }
    }

    public void U(ff ffVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ffVar) == null) {
            this.b = ffVar;
        }
    }

    public void V(gf gfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gfVar) == null) {
            this.c = gfVar;
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f = i2;
        }
    }

    public void Y(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            this.z = arrayList;
            AbsMsglistView.j jVar = this.D;
            if (jVar != null) {
                jVar.a(arrayList, false);
            }
        }
    }

    public void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.A = i2;
        }
    }

    public void b0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, chatMessage) == null) {
            ShareChatroomMsgData d2 = ve8.d(chatMessage);
            ChatShareChatroomCard chatShareChatroomCard = this.s;
            if (chatShareChatroomCard != null) {
                chatShareChatroomCard.setVisibility(0);
                this.s.b(d2);
            }
        }
    }

    public void d0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, chatMessage) == null) {
            H(chatMessage);
            ShareForumMsgData e2 = ve8.e(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 33);
            this.q.a(e2);
        }
    }

    public void h0(@NonNull ChatMessage chatMessage) {
        ImShareCardCommonData c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, chatMessage) == null) && (c2 = ve8.c(chatMessage)) != null) {
            this.t.setVisibility(0);
            this.t.a(c2);
        }
    }

    public void j0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, chatMessage) == null) {
            H(chatMessage);
            ShareThreadMsgData f2 = ve8.f(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 32);
            this.q.a(f2);
        }
    }

    public void setUpdateListener(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, jVar) == null) {
            this.D = jVar;
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.E = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public final String G(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 < 1000) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 * 1000);
            Calendar calendar2 = this.e;
            if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.e.get(6) == calendar.get(6)) {
                return bi.getDateStringHm(calendar.getTime());
            }
            return bi.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = (TextView) u(R.id.tex_msgitem_time);
            TbRichTextView tbRichTextView = (TbRichTextView) u(R.id.tex_msgitem_text);
            this.j = tbRichTextView;
            tbRichTextView.setLinkTextColor(-14845754);
            this.j.setFaceSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X04));
            this.p = (ChatImageWithTailView) u(R.id.img_msgitem_image);
            this.B = (TbCheckBox) u(R.id.ckb_select);
            this.C = (LinearLayout) u(R.id.ll_ckb_select);
            this.m = (ShareFromPBView) u(R.id.lay_msgitem_share_view);
            this.n = (ShareFromFrsView) u(R.id.lay_msgitem_share_frs);
            this.o = (ShareFromGameCenter) u(R.id.lay_msgitem_share_game);
            this.r = (GamePlayCardMsgView) u(R.id.lay_msgitem_gameplay_card);
            ChatVoiceView chatVoiceView = (ChatVoiceView) u(R.id.lay_msgitem_voice);
            this.k = chatVoiceView;
            chatVoiceView.setClickable(true);
            ChatVoiceView chatVoiceView2 = this.k;
            chatVoiceView2.setOnClickListener(chatVoiceView2);
            ChatShareCard chatShareCard = (ChatShareCard) u(R.id.share_card_container);
            this.q = chatShareCard;
            chatShareCard.V = 2;
            ChatShareChatroomCard chatShareChatroomCard = (ChatShareChatroomCard) u(R.id.share_group_card);
            this.s = chatShareChatroomCard;
            chatShareChatroomCard.setScene(2);
            ChatShareCommonCard chatShareCommonCard = (ChatShareCommonCard) u(R.id.share_common_card);
            this.t = chatShareCommonCard;
            chatShareCommonCard.setScene(2);
            K();
            this.j.setOnClickListener(new h(this));
            this.k.setLongClickable(true);
            this.k.setOnLongClickListener(new i(this));
            this.p.getImage().setClickable(true);
            this.p.getImage().setOnClickListener(new j(this));
            this.p.getImage().setLongClickable(true);
            this.p.getImage().setOnLongClickListener(new k(this));
            this.p.getTail().setClickable(true);
            this.p.getTail().setOnClickListener(new l(this));
            this.j.setLongClickable(true);
            this.j.setOnLongClickListener(new m(this));
            GifView gifView = (GifView) u(R.id.emotion_msgitem_image);
            this.l = gifView;
            gifView.setSupportNoImage(false);
            this.l.setOnClickListener(new n(this));
            this.l.setLongClickable(true);
            this.l.setOnLongClickListener(new o(this));
            this.m.setClickable(true);
            this.m.setOnClickListener(new p(this));
            this.m.setLongClickable(true);
            this.m.setOnLongClickListener(new a(this));
            this.n.setClickable(true);
            this.n.setOnClickListener(new b(this));
            this.n.setLongClickable(true);
            this.n.setOnLongClickListener(new c(this));
            this.o.getContentBody().setClickable(true);
            this.o.getContentBody().setOnClickListener(new d(this));
            this.o.getTail().setClickable(true);
            this.o.getTail().setOnClickListener(new e(this));
            this.o.getContentBody().setLongClickable(true);
            this.o.getContentBody().setOnLongClickListener(new f(this));
        }
    }

    public void N(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, chatMessage) == null) {
            ChatMessage chatMessage2 = this.F;
            if (chatMessage2 == null || (chatMessage != null && chatMessage2.getMsgId() != chatMessage.getMsgId())) {
                E(chatMessage);
            }
            this.F = chatMessage;
            if (chatMessage != null) {
                chatMessage.setItemView(this);
                this.h = Long.valueOf(chatMessage.getMsgId());
            }
        }
    }

    public void a0(ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, chatMessage, z) == null) {
            da8.b(this.mContext.getContext(), this.l, chatMessage, z);
        }
    }

    public void k0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, chatMessage, str) == null) {
            da8.g(this.mContext.getContext(), this.k, chatMessage, str);
        }
    }

    public void c0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, view2, chatMessage, str) == null) {
            da8.c(this.mContext.getContext(), view2, this.m, this.n, this.o, chatMessage, str);
        }
    }

    public void g0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, view2, chatMessage, str) == null) {
            da8.e(this.mContext.getContext(), view2, this.p, chatMessage, this.g, str);
        }
    }

    public void e0(@NonNull ChatMessage chatMessage) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, chatMessage) == null) {
            if (!this.u.booleanValue() && (runTask = MessageManager.getInstance().runTask(2921735, null, null)) != null && runTask.getData() != null) {
                this.u = (Boolean) runTask.getData();
            }
            H(chatMessage);
            GamePlayOrderMsgData b2 = ve8.b(chatMessage);
            this.r.setVisibility(0);
            this.r.setData(b2);
        }
    }

    public void f0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, chatMessage) == null) {
            if (chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1) {
                z = true;
            } else {
                z = false;
            }
            boolean J = J(chatMessage.getTime());
            if (!z && !J) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(G(chatMessage.getTime()));
            }
            if (!z && J) {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    MsgCacheData msgCacheData = new MsgCacheData();
                    msgCacheData.setIs_show_time(1);
                    chatMessage.setCacheData(msgCacheData);
                    return;
                }
                cacheData.setIs_show_time(1);
            }
        }
    }

    public void i0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, chatMessage, str) == null) {
            da8.f(this.j, chatMessage, str, this.A);
            if (chatMessage != null && chatMessage.getContent() != null) {
                String[] split = chatMessage.getContent().split("#");
                StringBuffer stringBuffer = new StringBuffer();
                for (String str2 : split) {
                    stringBuffer.append(str2);
                }
                this.j.setContentDescription(stringBuffer.toString());
                this.j.getTextView().setContentDescription(stringBuffer.toString());
            }
        }
    }

    public void l0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, chatMessage) == null) {
            if (this.z == null) {
                this.z = new ArrayList<>();
            }
            if (this.y) {
                this.C.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 < this.z.size()) {
                        ReportPrivateMsgData reportPrivateMsgData = this.z.get(i2);
                        if (reportPrivateMsgData != null && TextUtils.equals(String.valueOf(chatMessage.getMsgId()), reportPrivateMsgData.getMsgId())) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                this.C.setTag(Boolean.valueOf(z));
                this.B.setTagData(new q(this));
                this.B.setBackgroundDrawableIdIsWebP(true);
                this.B.setClickable(false);
                this.B.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
                this.B.setChecked(((Boolean) this.C.getTag()).booleanValue());
                this.C.setOnClickListener(new g(this, chatMessage));
                return;
            }
            this.C.setVisibility(8);
        }
    }
}
