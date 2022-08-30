package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class bd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public boolean C;
    public String D;
    public String E;
    public int F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public int L;
    public MetaData M;
    public String N;
    public boolean O;
    public ForumData P;
    public int Q;
    public ArrayList<String> a;
    public HashMap<String, String> b;
    public Map<String, ImageUrlData> c;
    public ArrayList<AlaInfoData> d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public a n;
    public int o;
    public boolean p;
    public boolean q;
    public b r;
    public AdvertAppInfo s;
    public String t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public String y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, ed7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public int e;
        public final /* synthetic */ bd7 f;

        public a(bd7 bd7Var, String str, String str2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd7Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bd7Var;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.e = 0;
            this.c = str2;
            this.b = str;
            this.d = i;
            this.e = i2;
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.addPostData("forum_id", this.f.h);
                this.a.addPostData("user_id", this.f.t == null ? "0" : this.f.t);
                this.a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.a.addPostData("scr_w", String.valueOf(ri.k(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(ri.i(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("q_type", String.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                this.a.addPostData("_os_version", Build.VERSION.RELEASE);
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.f.a.size()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public ed7 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.f.i);
                this.a.addPostData("tid", this.b);
                String str = this.c;
                if (str != null) {
                    this.a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.f.e) && !"0".equals(this.f.e)) {
                    this.a.addPostData("post_id", this.f.e);
                }
                this.a.addPostData("source", String.valueOf(this.f.q ? 1 : 2));
                this.f.q = false;
                this.a.addPostData(UnitedSchemeConstants.UNITED_SCHEME_NEXT, String.valueOf(this.d));
                this.a.addPostData("prev", String.valueOf(this.e));
                this.a.addPostData("not_see_lz", String.valueOf(!this.f.p ? 1 : 0));
                this.a.addPostData("is_top_agree", String.valueOf(this.f.B ? 1 : 2));
                if (!this.f.m) {
                    this.a.addPostData("r", String.valueOf(1));
                }
                if (!StringUtils.isNull(this.f.u, true)) {
                    this.a.addPostData("obj_type", this.f.u);
                } else {
                    this.a.addPostData("obj_type", ImageViewerConfig.FROM_OTHER);
                }
                if (TextUtils.isEmpty(this.f.x)) {
                    if (System.currentTimeMillis() - tu4.k().m("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.f.x = tu4.k().q("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.f.x);
                String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                if (!TextUtils.isEmpty(lastCachedOid)) {
                    this.a.addPostData("oaid", lastCachedOid);
                }
                this.a.addPostData("app_transmit_data", ee5.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    ed7 ed7Var = new ed7();
                    ed7Var.l(postNetData, true);
                    return ed7Var;
                }
                return null;
            }
            return (ed7) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f.n = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(ed7 ed7Var) {
            ImageUrlData imageUrlData;
            boolean z;
            boolean z2;
            int i;
            int i2;
            AgreeData agreeData;
            String str;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ed7Var) == null) {
                super.onPostExecute(ed7Var);
                if (this.f.c == null) {
                    return;
                }
                String str2 = null;
                this.f.n = null;
                if (ed7Var == null) {
                    if (this.f.r != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i3 = netWork.getServerErrorCode();
                            if (this.c == null) {
                                str2 = this.a.getErrorString();
                            }
                        } else {
                            i3 = -1;
                        }
                        this.f.r.b(i3, str2);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(ed7Var.g());
                if (this.f.z && !isEmpty) {
                    this.f.a.clear();
                    this.f.c.clear();
                    this.f.b.clear();
                }
                if (ed7Var.h() != 0) {
                    this.f.o = ed7Var.h();
                }
                this.f.s = ed7Var.a();
                this.f.Q = ed7Var.m;
                bd7 bd7Var = this.f;
                bd7Var.K = ed7Var.i;
                bd7Var.L = ed7Var.i();
                bd7 bd7Var2 = this.f;
                bd7Var2.M = ed7Var.k;
                bd7Var2.N = ed7Var.j;
                bd7Var2.O = ed7Var.l == 1;
                if (this.c == null) {
                    this.f.a.clear();
                    this.f.b.clear();
                }
                LinkedList<cd7> g = ed7Var.g();
                int size = g.size();
                if (size <= 0) {
                    imageUrlData = null;
                    z = isEmpty;
                    this.f.l = true;
                } else {
                    int i4 = 0;
                    while (i4 < size) {
                        cd7 cd7Var = g.get(i4);
                        String S = this.f.S(cd7Var);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String g2 = cd7Var.g();
                        imageUrlData2.id = g2;
                        if (StringHelper.equals(g2, this.f.A)) {
                            imageUrlData2.setSourceImageRectInScreen(this.f.y);
                        }
                        imageUrlData2.imageUrl = S;
                        String str3 = S + "*" + cd7Var.l();
                        imageUrlData2.mWidth = cd7Var.t();
                        imageUrlData2.mHeigth = cd7Var.f();
                        imageUrlData2.urlType = 10;
                        imageUrlData2.originalUrl = cd7Var.j();
                        boolean z3 = isEmpty;
                        imageUrlData2.originalSize = cd7Var.k();
                        imageUrlData2.picId = cd7Var.m();
                        imageUrlData2.forumId = this.f.h;
                        imageUrlData2.forumName = this.f.i;
                        imageUrlData2.threadId = pg.g(this.b, -1L);
                        imageUrlData2.nid = this.f.g;
                        imageUrlData2.postId = pg.g(cd7Var.c(), -1L);
                        imageUrlData2.userId = cd7Var.q();
                        imageUrlData2.userNameShow = StringUtils.isNull(cd7Var.s()) ? cd7Var.r() : cd7Var.s();
                        imageUrlData2.mIsReserver = this.f.m;
                        imageUrlData2.mIsSeeHost = this.f.p;
                        imageUrlData2.overAllIndex = cd7Var.l();
                        imageUrlData2.mThreadType = this.f.v;
                        imageUrlData2.mPicType = cd7Var.n();
                        imageUrlData2.mTagName = cd7Var.p();
                        imageUrlData2.mIsShowOrigonButton = cd7Var.x();
                        imageUrlData2.isLongPic = cd7Var.w();
                        imageUrlData2.isBlockedPic = cd7Var.u();
                        imageUrlData2.from = this.f.u;
                        if (cd7Var.o() != null) {
                            imageUrlData2.richTextArray = cd7Var.o().toString();
                        }
                        imageUrlData2.isFirstPost = cd7Var.v();
                        if (cd7Var.a() != null) {
                            AgreeData a = cd7Var.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = true;
                            a.mImageViewerFromPage = this.f.u;
                            imageUrlData2.agreeData.forumId = this.f.h;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = cd7Var.d();
                            if (cd7Var.v()) {
                                AgreeData agreeData3 = imageUrlData2.agreeData;
                                agreeData3.objType = 3;
                                agreeData3.isInThread = true;
                                agreeData3.isInPost = false;
                            } else {
                                AgreeData agreeData4 = imageUrlData2.agreeData;
                                agreeData4.objType = 1;
                                agreeData4.isInThread = false;
                                agreeData4.isInPost = true;
                            }
                            imageUrlData2.agreeData.cardType = this.f.F;
                            imageUrlData2.agreeData.recomSource = this.f.G;
                            imageUrlData2.agreeData.recomAbTag = this.f.H;
                            imageUrlData2.agreeData.recomExtra = this.f.J;
                            imageUrlData2.agreeData.recomWeight = this.f.I;
                        }
                        imageUrlData2.faceGroupInfoData = cd7Var.e();
                        String str4 = imageUrlData2.id + "_" + cd7Var.l();
                        if (this.f.b.containsKey(str4)) {
                            String str5 = (String) this.f.b.get(str4);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.f.c.get(str5);
                            if (imageUrlData3 == null) {
                                this.f.c.put(str5, imageUrlData2);
                            } else {
                                imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                                imageUrlData3.picId = imageUrlData2.picId;
                                imageUrlData3.overAllIndex = imageUrlData2.overAllIndex;
                                imageUrlData3.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                imageUrlData3.isLongPic = imageUrlData2.isLongPic;
                                imageUrlData3.richTextArray = imageUrlData2.richTextArray;
                                imageUrlData3.commentNum = imageUrlData2.commentNum;
                                imageUrlData3.agreeData = imageUrlData2.agreeData;
                                imageUrlData3.isFirstPost = imageUrlData2.isFirstPost;
                                imageUrlData3.userId = imageUrlData2.userId;
                                imageUrlData3.userNameShow = imageUrlData2.userNameShow;
                                imageUrlData3.forumId = this.f.h;
                                imageUrlData3.forumName = this.f.i;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                imageUrlData3.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                if (StringHelper.equals(imageUrlData2.id, this.f.A)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.f.y);
                                }
                            }
                            str = null;
                        } else if (!this.f.C) {
                            str = null;
                            this.f.c.put(str3, imageUrlData2);
                            if (!this.f.w || i4 >= this.f.a.size()) {
                                this.f.a.add(str3);
                            } else {
                                this.f.a.add(i4, str3);
                            }
                            this.f.b.put(str4, str3);
                        } else {
                            bd7 bd7Var3 = this.f;
                            bd7Var3.o = bd7Var3.c.size();
                            str = null;
                            this.f.s = null;
                        }
                        i4++;
                        isEmpty = z3;
                        str2 = str;
                    }
                    imageUrlData = str2;
                    z = isEmpty;
                    cd7 cd7Var2 = (cd7) ListUtils.getItem(g, 0);
                    if (cd7Var2 != null) {
                        this.f.j = cd7Var2.g();
                    }
                    cd7 cd7Var3 = (cd7) ListUtils.getItem(g, size - 1);
                    if (cd7Var3 != null) {
                        this.f.k = cd7Var3.g();
                        bd7 bd7Var4 = this.f;
                        bd7Var4.l = ((long) bd7Var4.o) == cd7Var3.l();
                    }
                }
                ImageUrlData imageUrlData4 = imageUrlData;
                for (ImageUrlData imageUrlData5 : this.f.c.values()) {
                    if (imageUrlData5.agreeData == null) {
                        long j = imageUrlData5.postId;
                        if (imageUrlData4 == null) {
                            for (ImageUrlData imageUrlData6 : this.f.c.values()) {
                                if (imageUrlData6.postId == j && (agreeData = imageUrlData6.agreeData) != null) {
                                    imageUrlData5.agreeData = agreeData;
                                    imageUrlData5.richTextArray = imageUrlData6.richTextArray;
                                    imageUrlData5.commentNum = imageUrlData6.commentNum;
                                    imageUrlData5.userId = imageUrlData6.userId;
                                    imageUrlData5.userNameShow = imageUrlData6.userNameShow;
                                    imageUrlData5.faceGroupInfoData = imageUrlData6.faceGroupInfoData;
                                    imageUrlData5.forumId = this.f.h;
                                    imageUrlData5.forumName = this.f.i;
                                    imageUrlData4 = imageUrlData6;
                                }
                            }
                        } else if (j == imageUrlData4.postId) {
                            imageUrlData5.agreeData = imageUrlData4.agreeData;
                            imageUrlData5.richTextArray = imageUrlData4.richTextArray;
                            imageUrlData5.commentNum = imageUrlData4.commentNum;
                            imageUrlData5.userId = imageUrlData4.userId;
                            imageUrlData5.userNameShow = imageUrlData4.userNameShow;
                            imageUrlData5.faceGroupInfoData = imageUrlData4.faceGroupInfoData;
                            imageUrlData5.forumId = this.f.h;
                            imageUrlData5.forumName = this.f.i;
                        }
                    }
                }
                if (this.c == null) {
                    this.f.f = this.b;
                    z2 = true;
                    i = 0;
                } else {
                    z2 = false;
                    i = -1;
                }
                if (this.f.w) {
                    if (!if7.f(this.f.b)) {
                        for (String str6 : this.f.b.keySet()) {
                            if (!TextUtils.isEmpty(str6) && str6.contains(this.c)) {
                                imageUrlData = (String) this.f.b.get(str6);
                            }
                        }
                    }
                    i2 = ListUtils.getPosition(this.f.a, imageUrlData) - 1;
                } else {
                    i2 = i;
                }
                this.f.D = ed7Var.e();
                this.f.E = ed7Var.j();
                this.f.P = ed7Var.f();
                if (this.f.d == null) {
                    this.f.d = new ArrayList();
                    if (ed7Var.d() != null && ed7Var.g().size() > 0) {
                        this.f.d.addAll(ed7Var.d());
                    }
                }
                if (this.f.r != null) {
                    this.f.r.a(this.f.a, i2, this.f.o, false, null, z2, this.f.s, z);
                }
                this.f.z = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    public bd7(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str8, str9, str10, str11};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.l = false;
        this.m = true;
        this.n = null;
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.w = false;
        this.C = false;
        this.a = arrayList;
        this.c = map;
        if (arrayList == null) {
            this.a = new ArrayList<>();
        }
        int i5 = 0;
        while (i5 < this.a.size()) {
            String str12 = this.a.get(i5);
            StringBuilder sb = new StringBuilder();
            sb.append(ad7.a(str12));
            sb.append("_");
            i5++;
            sb.append(i5);
            this.b.put(sb.toString(), str12);
        }
        this.f = str3;
        this.g = str4;
        this.i = str2;
        this.h = str;
        this.k = str5;
        this.v = i;
        this.l = str5 == null;
        this.t = str6;
        this.u = str7;
        this.z = z;
        this.B = false;
        this.F = i2;
        this.G = str8;
        this.H = str9;
        this.I = str10;
        this.J = str11;
    }

    public final String S(cd7 cd7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cd7Var)) == null) {
            if (cd7Var.b() != null && cd7Var.b().length() > 0) {
                return cd7Var.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (cd7Var.f() * cd7Var.t() > i) {
                double sqrt = Math.sqrt(i / (cd7Var.f() * cd7Var.t()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (cd7Var.t() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (cd7Var.f() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(cd7Var.t()));
                sb.append("&height=");
                sb.append(String.valueOf(cd7Var.f()));
            }
            sb.append("&src=");
            sb.append(qi.getUrlEncode(cd7Var.h()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (ArrayList) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.w = false;
            if (this.l) {
                return;
            }
            i0(this.f, this.k, 10, 0);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.w = true;
            String str = this.a.get(0);
            if (StringUtils.isNull(this.j)) {
                this.j = ad7.a(str);
            }
            i0(this.f, this.j, 0, 10);
        }
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Q : invokeV.intValue;
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.A = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.q = z;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.C = z;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.B = z;
        }
    }

    public void d0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.e = str;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.m = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.y = str;
        }
    }

    public final void i0(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048592, this, str, str2, i, i2) == null) {
            a aVar = this.n;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.n.cancel();
            }
            a aVar2 = new a(this, str, str2, i, i2);
            this.n = aVar2;
            aVar2.setPriority(3);
            this.n.execute(new Object[0]);
        }
    }
}
