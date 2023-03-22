package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.ThemeBubbleData;
import com.baidu.tieba.un;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.FestivalTipData;
import tbclient.FullLengthNovel;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes3.dex */
public class bc9 implements PreLoadImageProvider, gn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public static final BdUniqueId R0;
    public static final BdUniqueId S0;
    public static final BdUniqueId T0;
    public static final BdUniqueId U0;
    public static final BdUniqueId V0;
    public static final BdUniqueId W0;
    public static final BdUniqueId X0;
    public static boolean Y0;
    public transient /* synthetic */ FieldHolder $fh;
    public iz4 A;
    public int A0;
    public int B;
    public int B0;
    public String C;
    public boolean C0;
    public boolean D;
    public boolean D0;
    public int E;
    public VirtualImageCustomFigure E0;
    public zt5 F;
    public VirtualImageCustomState F0;
    public TbRichTextVoiceInfo G;
    public boolean G0;
    public ArrayList<fa5> H;
    public ThemeBubbleData H0;
    public String I;
    public FullLengthNovel I0;
    public SkinInfo J;
    public vp9 J0;
    public String K;
    public xp9 K0;
    public AgreeData L;
    public d L0;
    public boolean M;
    public Boolean M0;
    public boolean N;
    public int N0;
    public int O;
    public int O0;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public AlaLiveInfoCoreData T;
    public boolean U;
    public OriginalThreadInfo V;
    public int W;
    public String X;
    public boolean Y;
    public boolean Z;
    public int a;
    public boolean a0;
    public String b;
    public boolean b0;
    public long c;
    public boolean c0;
    public int d;
    public int d0;
    public long e;
    public StatisticItem e0;
    public MetaData f;
    public List<HeadItem> f0;
    @Deprecated
    public String g;
    public Item g0;
    public ArrayList<yb9> h;
    public boolean h0;
    public ArrayList<yb9> i;
    public List<PbContent> i0;
    public int j;
    public int j0;
    public ArrayList<bc9> k;
    public boolean l;
    public ArrayList<bc9> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public ly4 q;
    public pb9 r;
    public Item r0;
    public String s;
    public int s0;
    public String t;
    public ca5 t0;
    public String u;
    public ra5 u0;
    public HashMap<String, MetaData> v;
    public List<CardLinkInfoData> v0;
    public fa5 w;
    public zb9 w0;
    public oa5 x;
    public long x0;
    public boolean y;
    public String y0;
    public ub9 z;
    public boolean z0;

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    public void g1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements un.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ bc9 c;

        /* loaded from: classes3.dex */
        public class a extends bg<rm> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ un a;
            public final /* synthetic */ b b;

            public a(b bVar, un unVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, unVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = unVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.bg
            public void onLoaded(rm rmVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                    super.onLoaded((a) rmVar, str, i);
                    if (rmVar != null && rmVar.w()) {
                        this.a.a(this.b.c.h(rmVar));
                        this.b.c.n.isChanged = true;
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                    }
                }
            }
        }

        public b(bc9 bc9Var, IconData iconData, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc9Var, iconData, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bc9Var;
            this.a = iconData;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.un.a
        public Drawable a(un unVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, unVar)) == null) {
                rm rmVar = (rm) cg.h().n(this.a.getIcon(), 21, new Object[0]);
                if (rmVar == null) {
                    cg.h().m(this.a.getIcon(), 21, new a(this, unVar), this.b);
                }
                return this.c.h(rmVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bc9 a;

        public a(bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bc9Var;
        }

        @Override // com.baidu.tieba.bc9.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (statisticItem = this.a.e0) != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 7);
                TiebaStatic.log(copy);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public d c;

        public c(String str, String str2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = str2;
            this.c = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b != null) {
                d dVar = this.c;
                if (dVar != null) {
                    dVar.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.getInst(), this.b, this.a, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                if (UbsABTestHelper.isPBPlanA()) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0318));
                } else {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
                }
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(!UbsABTestHelper.isPBPlanA());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947640305, "Lcom/baidu/tieba/bc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947640305, "Lcom/baidu/tieba/bc9;");
                return;
            }
        }
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
        R0 = BdUniqueId.gen();
        S0 = BdUniqueId.gen();
        T0 = BdUniqueId.gen();
        U0 = BdUniqueId.gen();
        V0 = BdUniqueId.gen();
        W0 = BdUniqueId.gen();
        X0 = BdUniqueId.gen();
    }

    public zt5 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            zt5 zt5Var = this.F;
            if (zt5Var != null) {
                return zt5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.T()) > 0) {
                Iterator<TbRichTextData> it = this.n.T().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 32) {
                        zt5 i0 = next.i0();
                        this.F = i0;
                        return i0;
                    }
                }
                return null;
            }
            return null;
        }
        return (zt5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.T()) > 0) {
                Iterator<TbRichTextData> it = this.n.T().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 512) {
                        TbRichTextVoiceInfo j0 = next.j0();
                        this.G = j0;
                        return j0;
                    }
                }
                return null;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public bc9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.k = null;
        this.l = false;
        this.m = null;
        this.n = null;
        this.y = false;
        this.B = 0;
        this.E = 0;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = true;
        this.R = false;
        this.S = false;
        this.U = false;
        this.W = 0;
        this.Y = true;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.h0 = false;
        this.j0 = 4;
        this.z0 = false;
        this.A0 = 0;
        this.C0 = false;
        this.D0 = false;
        this.L0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new ly4();
        this.r = new pb9();
        this.H = new ArrayList<>();
        this.O = 0;
        this.L = new AgreeData();
        this.H0 = ThemeBubbleData.DEFAULT;
    }

    public PreLoadImageInfo C() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (T = tbRichText.T()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = T.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Z().getWidth();
                    preLoadImageInfo.height = next.Z().getHeight();
                    preLoadImageInfo.imgUrl = next.Z().S();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.c0().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.c0().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.c0().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> T;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (T = tbRichText.T()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = T.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.d0() != null) {
                            sb.append(next.d0().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.U() != null && next.U().mGifInfo != null && (str = next.U().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                            String substring = str.substring(2, str.length() - 1);
                            sb.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                        }
                    } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                        sb.append(WebvttCueParser.CHAR_SPACE);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || this.h == null) {
            return;
        }
        int i = -1;
        int size = this.i.size();
        if (size > 0) {
            try {
                i = this.i.get(size - 1).getType();
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            yb9 yb9Var = this.h.get(i2);
            if (yb9.k(i, yb9Var.getType())) {
                this.i.get(size - 1).e(yb9Var.h());
            } else {
                if (yb9Var.getType() != 3 && yb9Var.getType() != 2 && yb9Var.getType() != 11) {
                    yb9 yb9Var2 = new yb9();
                    yb9Var2.l(0);
                    yb9Var2.e(yb9Var.h());
                    this.i.add(yb9Var2);
                    i = 0;
                    size++;
                }
                this.i.add(yb9Var);
                i = yb9Var.getType();
                size++;
            }
        }
    }

    public void A0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, post) == null) {
            B0(post, null);
        }
    }

    public void F0(ca5 ca5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ca5Var) == null) {
            this.t0 = ca5Var;
        }
    }

    public void G0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.d = i;
        }
    }

    public void K0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.x0 = j;
        }
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.y0 = str;
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.Z = z;
        }
    }

    public void N0(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ly4Var) == null) {
            this.q = ly4Var;
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.C0 = z;
        }
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.b = str;
        }
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.O0 = i;
        }
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.Y = z;
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.y = z;
        }
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.U = z;
        }
    }

    public void U0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bool) == null) {
            this.z0 = bool.booleanValue();
        }
    }

    public void V0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.B0 = i;
        }
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.G0 = z;
        }
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.l = z;
        }
    }

    public void Y0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, originalThreadInfo) == null) {
            this.V = originalThreadInfo;
        }
    }

    public void Z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.a = i;
        }
    }

    public void a1(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public void b1(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public void c(bc9 bc9Var) {
        ArrayList<bc9> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, bc9Var) == null) && bc9Var != null && (arrayList = this.k) != null) {
            arrayList.add(bc9Var);
            f();
        }
    }

    public void c1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bool) == null) {
            this.M0 = bool;
        }
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            this.j = i;
        }
    }

    public void e1(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public void f1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048640, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public Drawable h(rm rmVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, rmVar)) == null) {
            if (rmVar == null || (p = rmVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.D0 = z;
        }
    }

    public void i1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, hashMap) == null) {
            this.v = hashMap;
        }
    }

    public void j1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.E0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.F0 = virtualImageCustomState;
                virtualImageCustomState.parseProto(post.custom_state);
            }
        }
    }

    public void k1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            this.N0 = i;
        }
    }

    public boolean s0(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048675, this, z)) == null) {
            if (z) {
                i = 2;
            } else {
                i = 4;
            }
            if (e0() <= i && f0() > e0()) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public xp9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.K0;
        }
        return (xp9) invokeV.objValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.A0++;
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.A0--;
        }
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.X;
        }
        return (String) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.W;
        }
        return invokeV.intValue;
    }

    public long K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.x0;
        }
        return invokeV.longValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.y0;
        }
        return (String) invokeV.objValue;
    }

    public ly4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.q;
        }
        return (ly4) invokeV.objValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.C0;
        }
        return invokeV.booleanValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.O0;
        }
        return invokeV.intValue;
    }

    public Boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return Boolean.valueOf(this.z0);
        }
        return (Boolean) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.B0;
        }
        return invokeV.intValue;
    }

    public Item S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.g0;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.f0;
        }
        return (List) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.K;
        }
        return (String) invokeV.objValue;
    }

    public oa5 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.x;
        }
        return (oa5) invokeV.objValue;
    }

    public ra5 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.u0;
        }
        return (ra5) invokeV.objValue;
    }

    public OriginalThreadInfo X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.V;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.A0;
        }
        return invokeV.intValue;
    }

    public TbRichText Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.n;
        }
        return (TbRichText) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public Boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.M0;
        }
        return (Boolean) invokeV.objValue;
    }

    public SkinInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.J;
        }
        return (SkinInfo) invokeV.objValue;
    }

    public ArrayList<bc9> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (d0() != null) {
                return d0().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.j++;
        }
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public SmallTailInfo g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.p;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public ThemeBubbleData i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.H0;
        }
        return (ThemeBubbleData) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.j--;
        }
    }

    public long j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public long k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public HashMap<String, MetaData> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.v;
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.V;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.x0 != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public ca5 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.t0;
        }
        return (ca5) invokeV.objValue;
    }

    public AgreeData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.L;
        }
        return (AgreeData) invokeV.objValue;
    }

    public VirtualImageCustomFigure o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.E0;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048668, this) == null) && this.E == 0) {
            this.E = 1;
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.L.agreeType;
        }
        return invokeV.intValue;
    }

    public VirtualImageCustomState p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.F0;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public MetaData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.f;
        }
        return (MetaData) invokeV.objValue;
    }

    public int r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.N0;
        }
        return invokeV.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if ((TextUtils.isEmpty(this.g) || this.g.equals("0")) && (metaData = this.f) != null) {
                return metaData.getUserId();
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (f0() > 0 && d0() != null && d0().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<CardLinkInfoData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.v0;
        }
        return (List) invokeV.objValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.Z;
        }
        return invokeV.booleanValue;
    }

    public ub9 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.z;
        }
        return (ub9) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.G0;
        }
        return invokeV.booleanValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.L.disAgreeNum;
        }
        return invokeV.longValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<bc9> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public vp9 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.J0;
        }
        return (vp9) invokeV.objValue;
    }

    public void B0(Post post, @Nullable ThreadData threadData) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, post, threadData) != null) || post == null) {
            return;
        }
        try {
            this.b = String.valueOf(post.id);
            long longValue = post.tid.longValue();
            this.c = longValue;
            if (longValue == 0 && threadData != null) {
                this.c = gg.g(threadData.getTid(), 0L);
            }
            String str = post.title;
            this.d = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.e = intValue;
            StringHelper.getFormatTime(intValue);
            String valueOf = String.valueOf(post.author_id);
            this.g = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.g.equals("0") && this.v != null && (metaData = this.v.get(this.g)) != null) {
                this.f = metaData;
            }
            boolean z4 = true;
            if (post.need_log.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.M = z;
            if (post.img_num_abtest.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.N = z2;
            iz4 iz4Var = new iz4();
            this.A = iz4Var;
            iz4Var.i(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.I = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.somebodys_portrait);
            }
            this.j = post.sub_post_number.intValue();
            this.z = new ub9(post.tpoint_post);
            List<PbContent> list = post.content;
            this.i0 = post.content;
            post.is_wonderful_post.intValue();
            if (post.is_top_agree_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.b0 = z3;
            this.f0 = post.item_star;
            this.B = post.fold_comment_status.intValue();
            this.C = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.g0 = post.item;
            }
            if (this.g0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.r0 = post.outer_item;
            }
            I0(post);
            TbRichText b0 = TbRichTextView.b0(list, String.valueOf(this.c), true, this, threadData, E());
            this.n = b0;
            if (b0 != null) {
                b0.b0(gg.g(this.b, -1L));
                this.n.a0(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.f0);
                if (this.d == 1 && count != 0 && this.f0 != null) {
                    ArrayList<TbRichTextData> T = this.n.T();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(T, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(T, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.f0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.B0(ut5.s(i, false));
                        }
                    } else {
                        for (int size = this.f0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.f0.get(size);
                            if (headItem2 != null) {
                                i(T, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.g0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.m0(new TbRichTextEvaluateItemInfo(this.g0));
                    ListUtils.add(this.n.T(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        SubPostList subPostList = list2.get(i2);
                        bc9 bc9Var = new bc9();
                        bc9Var.L.parseProtobuf(subPostList.agree);
                        bc9Var.i1(this.v);
                        bc9Var.M0(this.Z);
                        bc9Var.z0(subPostList, false, threadData, E());
                        this.k.add(bc9Var);
                    }
                }
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                this.r.a(actPost);
            }
            this.s = post.bimg_url;
            this.t = post.dynamic_url;
            this.u = post.rumor_source_img;
            if (post.tail_info != null) {
                fa5 fa5Var = new fa5();
                this.w = fa5Var;
                fa5Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                oa5 oa5Var = new oa5();
                this.x = oa5Var;
                oa5Var.c(post.lbs_info);
            }
            this.q.c(post.present);
            this.o.setUserMap(this.v);
            this.o.parserProtobuf(post.zan);
            if (post.signature != null) {
                SmallTailInfo smallTailInfo = new SmallTailInfo();
                this.p = smallTailInfo;
                smallTailInfo.id = post.signature.signature_id.intValue();
                this.p.color = post.signature.fontColor;
                if (post.signature.content != null && post.signature.content.size() != 0) {
                    this.p.content = new ArrayList();
                    for (SignatureContent signatureContent : post.signature.content) {
                        List<SmallTailInfo.SmallTailInfoContent> list3 = this.p.content;
                        SmallTailInfo smallTailInfo2 = new SmallTailInfo();
                        smallTailInfo2.getClass();
                        list3.add(new SmallTailInfo.SmallTailInfoContent(smallTailInfo2, signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.p.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                    fa5 fa5Var2 = new fa5();
                    fa5Var2.b(post.ext_tails.get(i3));
                    this.H.add(fa5Var2);
                }
            }
            this.J = post.skin_info;
            this.K = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.L.postId = this.b;
                this.L.parseProtobuf(post.agree);
            }
            if (post.is_post_visible.intValue() != 1) {
                z4 = false;
            }
            this.S = z4;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.V = originalThreadInfo;
                originalThreadInfo.o(post.origin_thread_info);
            } else {
                this.V = null;
            }
            this.W = post.is_fold.intValue();
            this.X = post.fold_tip;
            if (post.advertisement != null) {
                ca5 ca5Var = new ca5();
                this.t0 = ca5Var;
                ca5Var.p(post.advertisement);
            }
            if (post.novel_info != null) {
                ra5 ra5Var = new ra5();
                this.u0 = ra5Var;
                ra5Var.j(post.novel_info);
                if (!ListUtils.isEmpty(this.i0) && this.i0.get(0) != null) {
                    this.u0.k(this.i0.get(0).text);
                }
            }
            if (this.v0 == null) {
                this.v0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i4 = 0; i4 < post.card_link_info.size(); i4++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i4));
                    this.v0.add(cardLinkInfoData);
                }
            }
            this.I0 = post.full_length_novel;
            if (post.bubble_info != null) {
                this.H0 = new ThemeBubbleData(post.bubble_info);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public String D() {
        InterceptResult invokeV;
        wb9 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PreLoadImageInfo C = C();
            if (C != null && !StringUtils.isNull(C.imgUrl)) {
                return C.imgUrl;
            }
            ub9 ub9Var = this.z;
            if (ub9Var != null && (a2 = ub9Var.a()) != null && !StringUtils.isNull(a2.a())) {
                return a2.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    n1();
                }
                ArrayList<yb9> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<yb9> it = arrayList.iterator();
                    while (it.hasNext()) {
                        yb9 next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.pic_str));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.voice_str));
                        } else if (next.getType() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !gi.isEmpty(next.f())) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(next.f());
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                    }
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(sb.toString());
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (T = tbRichText.T()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = T.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.Z() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.Z().getWidth();
                    preLoadImageInfo.height = next.Z().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.Z().Y()) {
                        preLoadImageInfo.imgUrl = next.Z().T();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.Z().S();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.U() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.U().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.U().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.U();
                    preLoadImageInfo2.procType = 20;
                    arrayList.add(preLoadImageInfo2);
                }
            }
            if (!TextUtils.isEmpty(this.s)) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.s;
                preLoadImageInfo3.width = 105;
                preLoadImageInfo3.width = 105;
                preLoadImageInfo3.procType = 19;
                arrayList.add(preLoadImageInfo3);
            }
            if (this.f == null) {
                return arrayList;
            }
            PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
            preLoadImageInfo4.imgUrl = this.f.getPortrait();
            preLoadImageInfo4.procType = 12;
            arrayList.add(preLoadImageInfo4);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> T;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (T = tbRichText.T()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = T.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.d0().toString());
                } else if (next.getType() == 17) {
                    String str = next.U().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.editor_image) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.video_title_str) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void I0(Post post) {
        FestivalTipData festivalTipData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, post) == null) && post != null && (festivalTipData = post.festival_tip_data) != null && !TextUtils.isEmpty(festivalTipData.text)) {
            this.J0 = vp9.a(post.festival_tip_data);
            FestivalTipData festivalTipData2 = post.festival_tip_data;
            if (festivalTipData2.background_color != null && festivalTipData2.font_color != null) {
                this.K0 = xp9.a(festivalTipData2);
            }
        }
    }

    public void b(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, bc9Var) != null) || bc9Var == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.j0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(bc9Var);
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048655, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            bc9 bc9Var = null;
            Iterator<bc9> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                bc9 next = it.next();
                if (next != null && str.equals(next.O())) {
                    bc9Var = next;
                    break;
                }
            }
            if (bc9Var != null) {
                this.m.remove(bc9Var);
            }
        }
    }

    public final q35 g(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048641, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z && !z2) {
                return null;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                q35 q35Var = new q35(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                q35Var.b(dimenPixelSize2);
                q35Var.f(false);
                q35Var.e(str);
                return q35Var;
            } else if (!" 吧主".equals(str) && !" 小吧主".equals(str) && !" 品牌官".equals(str)) {
                return null;
            } else {
                q35 q35Var2 = new q35(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                q35Var2.b(dimenPixelSize2);
                q35Var2.a(0.7f);
                q35Var2.f(true);
                q35Var2.e(str);
                return q35Var2;
            }
        }
        return (q35) invokeCommon.objValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return W0;
            }
            if (i == 1) {
                return S0;
            }
            if (i == 36) {
                return T0;
            }
            if (i != 40 && i != 50) {
                if (i == 41) {
                    return V0;
                }
                if (i == 53) {
                    return X0;
                }
                if (E() == 1) {
                    return P0;
                }
                zb9 zb9Var = this.w0;
                if (zb9Var != null && zb9Var.h()) {
                    if (this.w0.i()) {
                        return AdvertAppInfo.G;
                    }
                    return AdvertAppInfo.I;
                } else if (this.D0) {
                    return R0;
                } else {
                    return Q0;
                }
            }
            return U0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final void i(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            if (headItem.type.intValue() == 1) {
                str = headItem.content;
            } else {
                str = " ";
            }
            sb.append(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) ut5.s(i, true));
            }
            tbRichTextData.S(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void m1(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        boolean z2;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048662, this, tbPageContext, z) == null) && !this.a0 && tbPageContext != null && (tbRichText = this.n) != null && tbRichText.T() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                MetaData metaData2 = this.f;
                if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                    if (this.Z) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.f.getBawu_type())) {
                        str = " 吧主";
                    } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(this.f.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.f.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.f.getBawu_type())) {
                        str = " 管理吧务";
                    }
                }
                str = "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<IconData> tShowInfoNew = r().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    un unVar = new un(new b(this, it.next(), uniqueId), 0, 1);
                    unVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(unVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(i2);
            }
            if (!StringUtils.isNull(this.f.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.f.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.f != null) {
                spannableString = new SpannableString(sb2 + this.f.getName_show() + str + "：");
                str2 = this.f.getUserName();
                str3 = this.f.getUserId();
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
                str3 = null;
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                int i4 = i3 + 1;
                spannableString.setSpan(arrayList.get(i3), i3, i4, 17);
                i3 = i4;
            }
            MetaData metaData3 = this.f;
            if (metaData3 != null && !StringUtils.isNull(metaData3.getSealPrefix())) {
                Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                z35 z35Var = new z35(bitmapDrawable);
                z35Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
                spannableString.setSpan(z35Var, size, size + 1, 17);
            }
            spannableString.setSpan(new c(str2, str3, this.L0), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
                MetaData metaData4 = this.f;
                if (metaData4 != null && metaData4.getIs_bawu() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                q35 g = g(z, z2, str);
                if (g != null) {
                    MetaData metaData5 = this.f;
                    if (metaData5 != null) {
                        if (metaData5.getName_show() != null) {
                            i = this.f.getName_show().length();
                        } else {
                            i = 0;
                        }
                        spannableString.setSpan(g, sb2.length() + i + 1, sb2.length() + i + str.length(), 17);
                    } else {
                        spannableString.setSpan(g, sb2.length(), sb2.length() + str.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> T = this.n.T();
            if (T != null && T.size() > 0) {
                TbRichTextData tbRichTextData2 = T.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.d0() != null) {
                    if (this.U) {
                        int indexOf = tbRichTextData2.d0().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.d0().delete(0, indexOf + 1);
                        }
                        this.U = false;
                    }
                    tbRichTextData2.x0(sb.length());
                    tbRichTextData2.d0().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        if (i5 < T.size()) {
                            if (T.get(i5) != null && T.get(i5).getType() == 512) {
                                tbRichTextVoiceInfo = T.get(i5).j0();
                                T.remove(i5);
                                break;
                            }
                            i5++;
                        } else {
                            tbRichTextVoiceInfo = null;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.A0(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.x0(sb.length());
                    tbRichTextData.S(spannableString);
                    T.add(0, tbRichTextData);
                }
            }
            this.a0 = true;
        }
    }

    public void z0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048689, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) != null) || subPostList == null) {
            return;
        }
        try {
            this.b = String.valueOf(subPostList.id);
            String str = subPostList.title;
            this.d = subPostList.floor.intValue();
            long intValue = subPostList.time.intValue() * 1000;
            this.e = intValue;
            StringHelper.getFormatTime(intValue);
            this.g = String.valueOf(subPostList.author_id);
            this.L.postId = this.b;
            this.L.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && this.v != null && (metaData = this.v.get(this.g)) != null) {
                this.f = metaData;
            }
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f = metaData2;
            }
            TbRichText b0 = TbRichTextView.b0(subPostList.content, null, z, this, threadData, i);
            this.n = b0;
            if (b0 != null) {
                b0.b0(gg.g(this.b, -1L));
            }
            this.s0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
