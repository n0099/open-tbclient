package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.lw7;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class i38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.y e;
    public lw7 f;

    /* loaded from: classes4.dex */
    public class a implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        public a(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v31, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01bc A[Catch: Exception -> 0x04b3, TryCatch #0 {Exception -> 0x04b3, blocks: (B:5:0x0014, B:9:0x004a, B:11:0x005a, B:12:0x00af, B:15:0x00e9, B:17:0x00fc, B:19:0x0108, B:21:0x0112, B:22:0x011c, B:24:0x0122, B:26:0x0128, B:29:0x0139, B:32:0x014a, B:33:0x0180, B:36:0x0187, B:38:0x01bc, B:40:0x01e8, B:41:0x01fb, B:43:0x022d, B:45:0x0231, B:47:0x024a, B:48:0x0259, B:50:0x02af, B:52:0x02db, B:53:0x02ee, B:54:0x0321, B:57:0x032a, B:59:0x0332, B:62:0x0344, B:63:0x035e, B:65:0x0366, B:67:0x0374, B:68:0x037a, B:69:0x037d, B:71:0x0387, B:73:0x0391, B:75:0x039b, B:76:0x039f, B:78:0x03a5, B:80:0x03af, B:82:0x03c2, B:83:0x03da, B:85:0x03e5, B:86:0x03f4, B:88:0x0441, B:90:0x046d, B:91:0x0480), top: B:100:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            j38 q1;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.K().m2());
                    statisticItem.param("fid", this.a.a.K().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    if (this.a.b.v4()) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem2.param("fid", this.a.a.K().getForumId());
                        statisticItem2.param("tid", this.a.a.K().m2());
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("post_id", this.a.a.K().q1());
                        statisticItem2.param("obj_source", 1);
                        statisticItem2.param("obj_type", 10);
                        statisticItem2.param("obj_locate", this.a.b.L3());
                        TiebaStatic.log(statisticItem2);
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    if (this.a.a.K().S1().i0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i3 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().D() != null) {
                                ArrayList<TbRichTextImageInfo> D = tbRichTextView.getRichText().D();
                                int i4 = 0;
                                int i5 = -1;
                                while (i4 < D.size()) {
                                    if (D.get(i4) != null) {
                                        arrayList.add(D.get(i4).F());
                                        if (i5 == i3 && str != null && str.equals(D.get(i4).F())) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = D.get(i4).F();
                                        imageUrlData.originalUrl = D.get(i4).F();
                                        imageUrlData.isLongPic = D.get(i4).I();
                                        concurrentHashMap.put(D.get(i4).F(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.A(arrayList);
                                builder.E(i2);
                                builder.F(false);
                                builder.O(eVar.f);
                                builder.I(this.a.a.K().d2());
                                builder.y(concurrentHashMap);
                                builder.K(true);
                                builder.N(false);
                                if (this.a.a.K() != null) {
                                    builder.J(this.a.a.K().v1());
                                    builder.D(this.a.a.K().getFromForumId());
                                    if (this.a.a.K().S1() != null) {
                                        builder.Q(this.a.a.K().S1().O());
                                    }
                                }
                                ImageViewerConfig x = builder.x(this.a.a.getPageContext().getPageActivity());
                                x.getIntent().putExtra("from", "pb");
                                this.a.a.sendMessage(new CustomMessage(2010000, x));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            }
                        }
                        i2 = -1;
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList);
                        builder2.E(i2);
                        builder2.F(false);
                        builder2.O(eVar.f);
                        builder2.I(this.a.a.K().d2());
                        builder2.y(concurrentHashMap);
                        builder2.K(true);
                        builder2.N(false);
                        if (this.a.a.K() != null) {
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.B().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = kv7.a(r.B().get(this.a.c));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i6).equals(a)) {
                                    eVar.j = i6;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            if (r.getPostId() != 0 && (q1 = this.a.a.q1()) != null) {
                                ArrayList<Cdo> a2 = q1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<Cdo> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Cdo next = it.next();
                                        if ((next instanceof PostData) && r.getPostId() == dh.g(((PostData) next).L(), 0L)) {
                                            j28.b(this.a.a.K().S1(), (PostData) next, ((PostData) next).c0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList2)) {
                                String str2 = arrayList2.get(0);
                                concurrentHashMap2.put(str2, eVar.b.get(str2));
                            }
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList2);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.y(concurrentHashMap2);
                            builder3.N(false);
                            builder3.I(this.a.a.K().d2());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a.K() != null) {
                                builder3.J(this.a.a.K().v1());
                                builder3.D(this.a.a.K().getFromForumId());
                                if (this.a.a.K().S1() != null) {
                                    builder3.Q(this.a.a.K().S1().O());
                                }
                            }
                            ImageViewerConfig x3 = builder3.x(this.a.a.getPageContext().getPageActivity());
                            x3.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, x3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder4 = new ImageViewerConfig.Builder();
                        builder4.A(arrayList3);
                        builder4.C(eVar.c);
                        builder4.B(eVar.d);
                        builder4.R(eVar.e);
                        builder4.F(eVar.g);
                        builder4.K(true);
                        builder4.M(eVar.a.get(0));
                        builder4.y(concurrentHashMap3);
                        builder4.I(this.a.a.K().d2());
                        builder4.N(false);
                        builder4.O(eVar.f);
                        builder4.z(eVar.f);
                        builder4.G(false);
                        if (this.a.a.K() != null) {
                            builder4.J(this.a.a.K().v1());
                            builder4.D(this.a.a.K().getFromForumId());
                            if (this.a.a.K().S1() != null) {
                                builder4.Q(this.a.a.K().S1().O());
                            }
                        }
                        ImageViewerConfig x4 = builder4.x(this.a.a.getPageContext().getPageActivity());
                        x4.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x4));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements lw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i38 a;

        public b(i38 i38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i38Var;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091c1d) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.b5(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203c);
                            if (!(obj instanceof PostData)) {
                                return false;
                            }
                            PostData postData = (PostData) obj;
                            if (!TextUtils.isEmpty(postData.t()) && hq4.c().g()) {
                                return this.a.n(postData.L());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180c) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f09204f) instanceof SparseArray) {
                                this.a.q((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09204f));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091866) {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.q(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.K5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public i38(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseVideoPBReplyFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = false;
        this.e = new a(this);
        this.f = new lw7(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.B();
    }

    public final void e(jv7 jv7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jv7Var, arrayList) == null) || jv7Var == null || jv7Var.T() == null || jv7Var.T().a == null || (list = jv7Var.T().a) == null || arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list.size() <= 0 || arrayList.size() <= 0) {
            return;
        }
        arrayList3.addAll(list);
        Iterator<PostData> it = arrayList.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null) {
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    PostData postData = (PostData) it2.next();
                    if (postData != null && !TextUtils.isEmpty(next.L()) && !TextUtils.isEmpty(postData.L()) && next.L().equals(postData.L())) {
                        arrayList2.add(postData);
                    }
                }
            }
        }
        if (arrayList2.size() > 0) {
            arrayList3.removeAll(arrayList2);
        }
        if (arrayList3.size() > 0) {
            arrayList.addAll(arrayList3);
        }
    }

    public final TbRichText f(ArrayList<PostData> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText W = arrayList.get(i2).W();
                    if (W != null && (B = W.B()) != null) {
                        int size = B.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (B.get(i4) != null && B.get(i4).getType() == 8) {
                                i3++;
                                if (B.get(i4).F().B().equals(str) || B.get(i4).F().C().equals(str)) {
                                    int h = (int) ej.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i4).F().getWidth() * h;
                                    int height = B.get(i4).F().getHeight() * h;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return W;
                                } else if (i3 > i) {
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    public final int g(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i3 = i;
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i5);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i4++;
                        int h = (int) ej.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h;
                        int height = tbRichTextData.F().getHeight() * h;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i4 <= i2) {
                                    i3--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a2 = kv7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a2)) {
                                arrayList.add(a2);
                                if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                    String B = F.B();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        B = F.C();
                                    } else {
                                        imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.P()).get(VideoPbViewModel.class)).m() ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = B;
                                    imageUrlData.originalUrl = k(tbRichTextData);
                                    imageUrlData.originalSize = l(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                    imageUrlData.isLongPic = h(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = dh.g(this.a.K().m2(), -1L);
                                    imageUrlData.mIsReserver = this.a.K().d2();
                                    imageUrlData.mIsSeeHost = this.a.K().v1();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a2, imageUrlData);
                                    }
                                }
                            }
                            if (!this.d) {
                                i3++;
                            }
                        }
                    }
                }
                return i3;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public TbRichTextView.y j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (TbRichTextView.y) invokeV.objValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public lw7 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (lw7) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String q = ox4.k().q("bubble_link", "");
            if (StringUtils.isNull(q)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                yo4.s(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f054a), q + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048586, this, str, i, eVar) == null) || eVar == null) {
            return;
        }
        jv7 S1 = this.a.K().S1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.B().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = kv7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = ((VideoPbViewModel) ViewModelProviders.of(this.a.P()).get(VideoPbViewModel.class)).m() ? 17 : 18;
            }
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalSize = l(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
            imageUrlData.isLongPic = h(tbRichTextData);
            imageUrlData.postId = r.getPostId();
            imageUrlData.mIsReserver = this.a.K().d2();
            imageUrlData.mIsSeeHost = this.a.K().v1();
            eVar.b.put(a2, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.O() != null) {
                    eVar.e = S1.O().getId();
                }
                eVar.g = S1.s() == 1;
            }
            imageUrlData.threadId = dh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.F().size();
        this.d = false;
        eVar.j = -1;
        int g = S1.j() != null ? g(S1.j().W(), r, i, i, eVar.a, eVar.b) : i;
        for (int i2 = 0; i2 < size; i2++) {
            PostData postData = S1.F().get(i2);
            if (postData.L() == null || S1.j() == null || S1.j().L() == null || !postData.L().equals(S1.j().L())) {
                g = g(postData.W(), r, g, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.O() != null) {
                eVar.e = S1.O().getId();
            }
            eVar.g = S1.s() == 1;
        }
        eVar.j = g;
    }

    public AbsPbActivity.e p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String str2 = null;
            if (this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().F() != null && this.a.K().S1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i >= this.a.K().S1().F().size()) {
                        i = 0;
                        break;
                    } else if (str.equals(this.a.K().S1().F().get(i).L())) {
                        break;
                    } else {
                        i++;
                    }
                }
                PostData postData = this.a.K().S1().F().get(i);
                if (postData.W() != null && postData.W().B() != null) {
                    Iterator<TbRichTextData> it = postData.W().B().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.F() != null) {
                                str2 = next.F().B();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    kv7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, sparseArray) == null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f09203c) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null || this.a.K() == null || this.a.K().S1() == null || postData.C() == 1) {
            return;
        }
        String m2 = this.a.K().m2();
        String L = postData.L();
        int W = this.a.K().S1() != null ? this.a.K().S1().W() : 0;
        AbsPbActivity.e p = p(L);
        if (p == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, this.b.v4(), null, false, null, W, postData.c0(), this.a.K().S1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.K().R1());
        addBigImageData.setFromFrsForumId(this.a.K().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.K().r2());
        addBigImageData.setKeyFromForumId(this.a.K().getForumId());
        addBigImageData.setBjhData(this.a.K().k1());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.K() == null || this.a.K().S1() == null || str == null || i < 0) {
                return null;
            }
            jv7 S1 = this.a.K().S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = S1.F();
                e(S1, F);
                return f(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
