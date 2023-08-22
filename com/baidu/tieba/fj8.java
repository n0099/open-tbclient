package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes5.dex */
public class fj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public String C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public int H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public int N;
    public MetaData O;
    public String P;
    public boolean Q;
    public ForumData R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public final HashSet<String> f1104T;
    public int U;
    public ArrayList<String> a;
    public HashMap<String, String> b;
    public Map<String, ImageUrlData> c;
    public ArrayList<AlaInfoData> d;
    public ArrayList<tj8> e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public a p;
    public int q;
    public boolean r;
    public boolean s;
    public b t;
    public AdvertAppInfo u;
    public String v;
    public String w;
    public int x;
    public boolean y;
    public String z;

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<String> arrayList, int i, int i2, boolean z, String str, boolean z2, AdvertAppInfo advertAppInfo, boolean z3);

        void b(int i, String str);
    }

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, Integer, ij8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public String b;
        public String c;
        public int d;
        public int e;
        public String f;
        public final /* synthetic */ fj8 g;

        public a(fj8 fj8Var, String str, String str2, int i, int i2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj8Var, str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = fj8Var;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = 0;
            this.e = 0;
            this.f = "";
            this.c = str2;
            this.b = str;
            this.d = i;
            this.e = i2;
            this.f = str3;
        }

        public final void b() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.addPostData("forum_id", this.g.j);
                NetWork netWork = this.a;
                if (this.g.v != null) {
                    str = this.g.v;
                } else {
                    str = "0";
                }
                netWork.addPostData("user_id", str);
                this.a.addPostData(TiebaStatic.Params.SAMPLE_ID, TbSingleton.getInstance().getSampleId());
                this.a.addPostData("scr_w", String.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                this.a.addPostData("scr_h", String.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                NetWork netWork2 = this.a;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                netWork2.addPostData("q_type", String.valueOf(i));
                if (jz9.b()) {
                    this.a.addPostData(HttpRequest.OS_VERSION, DeviceInfoHelper.getOsVersion());
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, jz9.c());
                    String g = jz9.g(HttpRequest.OS_VERSION);
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, jz9.j());
                    }
                }
                this.a.addPostData("page_name", "PB");
                this.a.addPostData("pic_index", String.valueOf(this.g.U));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public ij8 doInBackground(Object... objArr) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.IMAGE_PB_ADDRESS);
                this.a = netWork;
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, this.g.k);
                this.a.addPostData("tid", this.b);
                String str = this.c;
                if (str != null) {
                    this.a.addPostData(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, str);
                }
                if (!TextUtils.isEmpty(this.g.g) && !"0".equals(this.g.g)) {
                    this.a.addPostData("post_id", this.g.g);
                }
                if (!TextUtils.isEmpty(this.f) && !"0".equals(this.f)) {
                    this.a.addPostData("current_post_id", this.f);
                }
                NetWork netWork2 = this.a;
                int i2 = 2;
                if (this.g.s) {
                    i = 1;
                } else {
                    i = 2;
                }
                netWork2.addPostData("source", String.valueOf(i));
                this.g.s = false;
                this.a.addPostData("next", String.valueOf(this.d));
                this.a.addPostData("prev", String.valueOf(this.e));
                this.a.addPostData("not_see_lz", String.valueOf(!this.g.r ? 1 : 0));
                NetWork netWork3 = this.a;
                if (this.g.D) {
                    i2 = 1;
                }
                netWork3.addPostData("is_top_agree", String.valueOf(i2));
                if (!this.g.o) {
                    this.a.addPostData("r", String.valueOf(1));
                }
                if (!StringUtils.isNull(this.g.w, true)) {
                    this.a.addPostData("obj_type", this.g.w);
                } else {
                    this.a.addPostData("obj_type", "other");
                }
                if (TextUtils.isEmpty(this.g.z)) {
                    if (System.currentTimeMillis() - SharedPrefHelper.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                        this.g.z = SharedPrefHelper.getInstance().getString("applist_intalled_apk_ids", "");
                    }
                }
                this.a.addPostData("applist", this.g.z);
                if (jz9.b()) {
                    String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
                    if (!TextUtils.isEmpty(lastCachedOid)) {
                        this.a.addPostData("oaid", lastCachedOid);
                    }
                } else {
                    this.a.addPostData(HttpRequest.NEED_DECRYPT, jz9.c());
                    String g = jz9.g("oaid");
                    if (!TextUtils.isEmpty(g)) {
                        this.a.addPostData(g, jz9.i());
                    }
                }
                this.a.addPostData("app_transmit_data", qv5.a());
                this.a.addPostData("ad_ext_params", AdExtParam.a.b().a());
                b();
                this.a.getNetContext().getRequest().mNeedBackgroundLogin = false;
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    ij8 ij8Var = new ij8();
                    ij8Var.n(postNetData, true);
                    return ij8Var;
                }
                return null;
            }
            return (ij8) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.g.p = null;
                super.cancel(true);
            }
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v26, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v56 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onPostExecute(ij8 ij8Var) {
            boolean z;
            ImageUrlData imageUrlData;
            boolean z2;
            boolean z3;
            int i;
            int i2;
            String str;
            AgreeData agreeData;
            boolean z4;
            String s;
            int i3;
            String str2;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ij8Var) == null) {
                super.onPostExecute(ij8Var);
                if (this.g.c == null) {
                    return;
                }
                String str3 = null;
                this.g.p = null;
                if (ij8Var == null) {
                    if (this.g.t != null) {
                        NetWork netWork = this.a;
                        if (netWork != null) {
                            i5 = netWork.getServerErrorCode();
                            if (this.c == null) {
                                str3 = this.a.getErrorString();
                            }
                        } else {
                            i5 = -1;
                        }
                        this.g.t.b(i5, str3);
                        return;
                    }
                    return;
                }
                boolean isEmpty = ListUtils.isEmpty(ij8Var.g());
                if (this.g.B && !isEmpty) {
                    this.g.a.clear();
                    this.g.c.clear();
                    this.g.b.clear();
                }
                if (ij8Var.h() != 0) {
                    this.g.q = ij8Var.h();
                }
                this.g.u = ij8Var.a();
                this.g.S = ij8Var.m;
                fj8 fj8Var = this.g;
                fj8Var.M = ij8Var.i;
                fj8Var.N = ij8Var.j();
                fj8 fj8Var2 = this.g;
                fj8Var2.O = ij8Var.k;
                fj8Var2.P = ij8Var.j;
                ?? r6 = 1;
                if (ij8Var.l == 1) {
                    z = true;
                } else {
                    z = false;
                }
                fj8Var2.Q = z;
                if (this.c == null) {
                    this.g.a.clear();
                    this.g.b.clear();
                }
                LinkedList<gj8> g = ij8Var.g();
                int size = g.size();
                if (size > 0) {
                    int i6 = 0;
                    while (i6 < size) {
                        gj8 gj8Var = g.get(i6);
                        String W = this.g.W(gj8Var);
                        ImageUrlData imageUrlData2 = new ImageUrlData();
                        String g2 = gj8Var.g();
                        imageUrlData2.id = g2;
                        if (StringHelper.equals(g2, this.g.C)) {
                            imageUrlData2.setSourceImageRectInScreen(this.g.A);
                        }
                        imageUrlData2.imageUrl = W;
                        String str4 = W + "*" + gj8Var.l();
                        imageUrlData2.mWidth = gj8Var.t();
                        imageUrlData2.mHeigth = gj8Var.f();
                        imageUrlData2.urlType = 27;
                        imageUrlData2.originalUrl = gj8Var.j();
                        boolean z5 = isEmpty;
                        imageUrlData2.originalSize = gj8Var.k();
                        imageUrlData2.picId = gj8Var.m();
                        imageUrlData2.forumId = this.g.j;
                        imageUrlData2.forumName = this.g.k;
                        imageUrlData2.threadId = JavaTypesHelper.toLong(this.b, -1L);
                        imageUrlData2.nid = this.g.i;
                        imageUrlData2.postId = JavaTypesHelper.toLong(gj8Var.c(), -1L);
                        imageUrlData2.userId = gj8Var.q();
                        if (StringUtils.isNull(gj8Var.s())) {
                            s = gj8Var.r();
                        } else {
                            s = gj8Var.s();
                        }
                        imageUrlData2.userNameShow = s;
                        imageUrlData2.mIsReserver = this.g.o;
                        imageUrlData2.mIsSeeHost = this.g.r;
                        imageUrlData2.overAllIndex = gj8Var.l();
                        imageUrlData2.mThreadType = this.g.x;
                        imageUrlData2.mPicType = gj8Var.n();
                        imageUrlData2.mTagName = gj8Var.p();
                        imageUrlData2.mIsShowOrigonButton = gj8Var.x();
                        imageUrlData2.isLongPic = gj8Var.w();
                        imageUrlData2.isBlockedPic = gj8Var.u();
                        imageUrlData2.from = this.g.w;
                        if (gj8Var.o() != null) {
                            imageUrlData2.richTextArray = gj8Var.o().toString();
                        }
                        imageUrlData2.isFirstPost = gj8Var.v();
                        if (gj8Var.a() != null) {
                            AgreeData a = gj8Var.a();
                            imageUrlData2.agreeData = a;
                            a.isFromImageViewer = r6;
                            a.mImageViewerFromPage = this.g.w;
                            imageUrlData2.agreeData.forumId = this.g.j;
                            imageUrlData2.agreeData.threadId = String.valueOf(imageUrlData2.threadId);
                            AgreeData agreeData2 = imageUrlData2.agreeData;
                            agreeData2.nid = imageUrlData2.nid;
                            agreeData2.postId = String.valueOf(imageUrlData2.postId);
                            imageUrlData2.agreeData.indexOfPic = imageUrlData2.overAllIndex;
                            imageUrlData2.commentNum = gj8Var.d();
                            if (gj8Var.v()) {
                                AgreeData agreeData3 = imageUrlData2.agreeData;
                                agreeData3.objType = 3;
                                agreeData3.isInThread = r6;
                                agreeData3.isInPost = false;
                            } else {
                                AgreeData agreeData4 = imageUrlData2.agreeData;
                                agreeData4.objType = r6;
                                agreeData4.isInThread = false;
                                agreeData4.isInPost = r6;
                            }
                            imageUrlData2.agreeData.cardType = this.g.H;
                            imageUrlData2.agreeData.recomSource = this.g.I;
                            imageUrlData2.agreeData.recomAbTag = this.g.J;
                            imageUrlData2.agreeData.recomExtra = this.g.L;
                            imageUrlData2.agreeData.recomWeight = this.g.K;
                        }
                        imageUrlData2.faceGroupInfoData = gj8Var.e();
                        String str5 = imageUrlData2.id + "_" + gj8Var.l();
                        if (!this.g.f1104T.isEmpty() && this.g.f1104T.contains(imageUrlData2.id) && this.g.b.containsKey(imageUrlData2.id)) {
                            String str6 = (String) this.g.b.get(imageUrlData2.id);
                            this.g.f1104T.remove(imageUrlData2.id);
                            int indexOf = this.g.a.indexOf(str6);
                            this.g.a.remove(str6);
                            this.g.b.remove(imageUrlData2.id);
                            ImageUrlData imageUrlData3 = (ImageUrlData) this.g.c.get(str6);
                            if (imageUrlData3 != null) {
                                imageUrlData3.imageUrl = imageUrlData2.imageUrl;
                                imageUrlData3.picId = imageUrlData2.picId;
                                i3 = i6;
                                imageUrlData3.overAllIndex = imageUrlData2.overAllIndex;
                                imageUrlData3.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                imageUrlData3.isLongPic = imageUrlData2.isLongPic;
                                imageUrlData3.richTextArray = imageUrlData2.richTextArray;
                                imageUrlData3.commentNum = imageUrlData2.commentNum;
                                imageUrlData3.agreeData = imageUrlData2.agreeData;
                                imageUrlData3.isFirstPost = imageUrlData2.isFirstPost;
                                imageUrlData3.userId = imageUrlData2.userId;
                                imageUrlData3.userNameShow = imageUrlData2.userNameShow;
                                imageUrlData3.forumId = this.g.j;
                                imageUrlData3.forumName = this.g.k;
                                imageUrlData3.mHeigth = imageUrlData2.mHeigth;
                                imageUrlData3.mWidth = imageUrlData2.mWidth;
                                imageUrlData3.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                if (StringHelper.equals(imageUrlData2.id, this.g.C)) {
                                    imageUrlData3.setSourceImageRectInScreen(this.g.A);
                                }
                                imageUrlData2.imageThumbUrl = imageUrlData3.imageThumbUrl;
                                imageUrlData2.urlThumbType = imageUrlData3.urlThumbType;
                            } else {
                                i3 = i6;
                            }
                            this.g.c.remove(str6);
                            this.g.c.put(str4, imageUrlData2);
                            if (indexOf >= 0 && indexOf < this.g.a.size()) {
                                this.g.a.add(indexOf, str4);
                            } else {
                                this.g.a.add(str4);
                            }
                            this.g.b.put(str5, str4);
                        } else {
                            i3 = i6;
                            if (this.g.b.containsKey(str5)) {
                                String str7 = (String) this.g.b.get(str5);
                                ImageUrlData imageUrlData4 = (ImageUrlData) this.g.c.get(str7);
                                if (imageUrlData4 == null) {
                                    this.g.c.put(str7, imageUrlData2);
                                } else {
                                    imageUrlData4.imageUrl = imageUrlData2.imageUrl;
                                    imageUrlData4.picId = imageUrlData2.picId;
                                    imageUrlData4.overAllIndex = imageUrlData2.overAllIndex;
                                    imageUrlData4.mIsShowOrigonButton = imageUrlData2.mIsShowOrigonButton;
                                    imageUrlData4.isLongPic = imageUrlData2.isLongPic;
                                    imageUrlData4.richTextArray = imageUrlData2.richTextArray;
                                    imageUrlData4.commentNum = imageUrlData2.commentNum;
                                    imageUrlData4.agreeData = imageUrlData2.agreeData;
                                    imageUrlData4.isFirstPost = imageUrlData2.isFirstPost;
                                    imageUrlData4.userId = imageUrlData2.userId;
                                    imageUrlData4.userNameShow = imageUrlData2.userNameShow;
                                    imageUrlData4.forumId = this.g.j;
                                    imageUrlData4.forumName = this.g.k;
                                    imageUrlData4.mHeigth = imageUrlData2.mHeigth;
                                    imageUrlData4.mWidth = imageUrlData2.mWidth;
                                    imageUrlData4.faceGroupInfoData = imageUrlData2.faceGroupInfoData;
                                    if (StringHelper.equals(imageUrlData2.id, this.g.C)) {
                                        imageUrlData4.setSourceImageRectInScreen(this.g.A);
                                    }
                                }
                            } else {
                                if (this.g.E) {
                                    fj8 fj8Var3 = this.g;
                                    fj8Var3.q = fj8Var3.c.size();
                                    str2 = null;
                                    this.g.u = null;
                                    i4 = i3;
                                } else {
                                    str2 = null;
                                    this.g.c.put(str4, imageUrlData2);
                                    if (this.g.y) {
                                        i4 = i3;
                                        if (i4 < this.g.a.size()) {
                                            this.g.a.add(i4, str4);
                                            this.g.b.put(str5, str4);
                                        }
                                    } else {
                                        i4 = i3;
                                    }
                                    this.g.a.add(str4);
                                    this.g.b.put(str5, str4);
                                }
                                i6 = i4 + 1;
                                isEmpty = z5;
                                str3 = str2;
                                r6 = 1;
                            }
                        }
                        i4 = i3;
                        str2 = null;
                        i6 = i4 + 1;
                        isEmpty = z5;
                        str3 = str2;
                        r6 = 1;
                    }
                    imageUrlData = str3;
                    z2 = isEmpty;
                    gj8 gj8Var2 = (gj8) ListUtils.getItem(g, 0);
                    if (gj8Var2 != null) {
                        this.g.l = gj8Var2.g();
                    }
                    gj8 gj8Var3 = (gj8) ListUtils.getItem(g, size - 1);
                    if (gj8Var3 != null) {
                        this.g.m = gj8Var3.g();
                        fj8 fj8Var4 = this.g;
                        if (fj8Var4.q == gj8Var3.l()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        fj8Var4.n = z4;
                    }
                } else {
                    imageUrlData = null;
                    z2 = isEmpty;
                    this.g.n = true;
                }
                ImageUrlData imageUrlData5 = imageUrlData;
                for (ImageUrlData imageUrlData6 : this.g.c.values()) {
                    if (imageUrlData6.agreeData == null) {
                        long j = imageUrlData6.postId;
                        if (imageUrlData5 == null) {
                            for (ImageUrlData imageUrlData7 : this.g.c.values()) {
                                if (imageUrlData7.postId == j && (agreeData = imageUrlData7.agreeData) != null) {
                                    imageUrlData6.agreeData = agreeData;
                                    imageUrlData6.richTextArray = imageUrlData7.richTextArray;
                                    imageUrlData6.commentNum = imageUrlData7.commentNum;
                                    imageUrlData6.userId = imageUrlData7.userId;
                                    imageUrlData6.userNameShow = imageUrlData7.userNameShow;
                                    imageUrlData6.faceGroupInfoData = imageUrlData7.faceGroupInfoData;
                                    imageUrlData6.forumId = this.g.j;
                                    imageUrlData6.forumName = this.g.k;
                                    imageUrlData5 = imageUrlData7;
                                }
                            }
                        } else if (j == imageUrlData5.postId) {
                            imageUrlData6.agreeData = imageUrlData5.agreeData;
                            imageUrlData6.richTextArray = imageUrlData5.richTextArray;
                            imageUrlData6.commentNum = imageUrlData5.commentNum;
                            imageUrlData6.userId = imageUrlData5.userId;
                            imageUrlData6.userNameShow = imageUrlData5.userNameShow;
                            imageUrlData6.faceGroupInfoData = imageUrlData5.faceGroupInfoData;
                            imageUrlData6.forumId = this.g.j;
                            imageUrlData6.forumName = this.g.k;
                        }
                    }
                }
                if (this.c == null) {
                    this.g.h = this.b;
                    z3 = true;
                    i = 0;
                } else {
                    z3 = false;
                    i = -1;
                }
                if (this.g.y) {
                    if (this.g.b != null && !this.g.b.isEmpty() && !TextUtils.isEmpty(this.c)) {
                        for (String str8 : this.g.b.keySet()) {
                            if (!TextUtils.isEmpty(str8) && str8.contains(this.c)) {
                                str = (String) this.g.b.get(str8);
                                break;
                            }
                        }
                    }
                    str = imageUrlData;
                    i2 = ListUtils.getPosition(this.g.a, str) - 1;
                } else {
                    i2 = i;
                }
                this.g.F = ij8Var.e();
                this.g.G = ij8Var.k();
                this.g.R = ij8Var.f();
                if (this.g.d == null) {
                    this.g.d = new ArrayList();
                    if (ij8Var.d() != null && ij8Var.g().size() > 0) {
                        this.g.d.addAll(ij8Var.d());
                    }
                }
                if (ij8Var.i() != null && !ij8Var.i().isEmpty()) {
                    if (this.g.e == null) {
                        this.g.e = new ArrayList();
                    } else {
                        this.g.e.clear();
                    }
                    this.g.e.addAll(ij8Var.i());
                }
                if (this.g.t != null) {
                    this.g.t.a(this.g.a, i2, this.g.q, false, null, z3, this.g.u, z2);
                }
                this.g.B = false;
            }
        }
    }

    public fj8(ArrayList<String> arrayList, Map<String, ImageUrlData> map, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, boolean z, int i2, String str8, String str9, String str10, String str11, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, map, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str8, str9, str10, str11, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.n = false;
        this.o = true;
        this.p = null;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = null;
        this.u = null;
        this.y = false;
        this.E = false;
        this.f1104T = new HashSet<>();
        this.a = arrayList;
        this.c = map;
        if (arrayList == null) {
            this.a = new ArrayList<>();
        }
        Iterator<String> it = this.a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String a2 = ej8.a(next);
            this.b.put(a2, next);
            this.f1104T.add(a2);
        }
        this.h = str3;
        this.i = str4;
        this.k = str2;
        this.j = str;
        this.m = str5;
        this.x = i;
        this.n = str5 == null;
        this.v = str6;
        this.w = str7;
        this.B = z;
        this.D = false;
        this.H = i2;
        this.I = str8;
        this.J = str9;
        this.K = str10;
        this.L = str11;
        this.U = i3;
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.g = str;
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.C = str;
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.U = i;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.E = z;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.D = z;
        }
    }

    public void m0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.t = bVar;
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f = str;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.o = z;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.r = z;
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.A = str;
        }
    }

    public final String W(gj8 gj8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gj8Var)) == null) {
            if (gj8Var.b() != null && gj8Var.b().length() > 0) {
                return gj8Var.b();
            }
            StringBuilder sb = new StringBuilder(150);
            int threadImageMaxWidth = TbConfig.getThreadImageMaxWidth();
            int i = threadImageMaxWidth * threadImageMaxWidth;
            if (gj8Var.f() * gj8Var.t() > i) {
                double sqrt = Math.sqrt(i / (gj8Var.f() * gj8Var.t()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (gj8Var.t() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (gj8Var.f() * sqrt)));
            } else {
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf(gj8Var.t()));
                sb.append("&height=");
                sb.append(String.valueOf(gj8Var.f()));
            }
            sb.append("&src=");
            sb.append(di.getUrlEncode(gj8Var.h()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<AlaInfoData> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.y = true;
            r0(this.h, this.m, 10, 10, this.f);
        }
    }

    public ArrayList<tj8> b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public void s0() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (aVar = this.p) != null) {
            aVar.cancel();
        }
    }

    public final String Y(String str) {
        InterceptResult invokeL;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.c == null || TextUtils.isEmpty(str) || (imageUrlData = this.c.get(str)) == null) {
                return "";
            }
            return String.valueOf(imageUrlData.postId);
        }
        return (String) invokeL.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.y = false;
            if (this.n) {
                return;
            }
            r0(this.h, this.m, 10, 0, Y((String) ListUtils.getItem(this.a, ListUtils.getCount(this.a) - 1)));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.y = true;
            String str = (String) ListUtils.getItem(this.a, 0);
            String Y = Y(str);
            if (StringUtils.isNull(this.l)) {
                this.l = ej8.a(str);
            }
            r0(this.h, this.l, 0, 10, Y);
        }
    }

    public final void r0(String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            a aVar = this.p;
            if (aVar != null) {
                if (str2 != null && str2.equals(aVar.d())) {
                    return;
                }
                this.p.cancel();
            }
            a aVar2 = new a(this, str, str2, i, i2, str3);
            this.p = aVar2;
            aVar2.setPriority(3);
            this.p.execute(new Object[0]);
        }
    }
}
