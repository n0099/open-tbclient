package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.uw8;
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
public class f39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.a0 e;
    public uw8 f;

    /* loaded from: classes4.dex */
    public class a implements TbRichTextView.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f39 a;

        public a(f39 f39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f39Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v32, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01c0 A[Catch: Exception -> 0x04c9, TryCatch #0 {Exception -> 0x04c9, blocks: (B:5:0x0014, B:9:0x004a, B:12:0x00d8, B:14:0x00de, B:16:0x00f1, B:18:0x00fd, B:20:0x0107, B:21:0x0111, B:23:0x0117, B:25:0x011d, B:28:0x012e, B:31:0x013f, B:35:0x015d, B:36:0x0184, B:39:0x018b, B:41:0x01c0, B:43:0x01ec, B:44:0x01ff, B:46:0x0234, B:48:0x0238, B:50:0x0251, B:51:0x0260, B:53:0x02b6, B:55:0x02e2, B:56:0x02f5, B:57:0x032b, B:60:0x0334, B:62:0x033c, B:65:0x034e, B:66:0x0368, B:68:0x0370, B:70:0x037e, B:71:0x0384, B:72:0x0387, B:74:0x0391, B:76:0x039b, B:78:0x03a5, B:79:0x03a9, B:81:0x03af, B:83:0x03b9, B:85:0x03cd, B:87:0x03ea, B:89:0x03f5, B:90:0x0404, B:92:0x0451, B:94:0x047d, B:95:0x0490), top: B:104:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.a0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            g39 F1;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.Q().S1());
                    statisticItem.param("fid", this.a.a.Q().getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    if (z2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    statisticItem.param("obj_type", i2);
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem2.param("fid", this.a.a.Q().getForumId());
                    statisticItem2.param("tid", this.a.a.Q().S1());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("post_id", this.a.a.Q().X0());
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 10);
                    statisticItem2.param("obj_locate", this.a.b.o3());
                    TiebaStatic.log(statisticItem2);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    qv8 z1 = this.a.a.Q().z1();
                    if (z1 != null && z1.h0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i5 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().Z() != null) {
                                ArrayList<TbRichTextImageInfo> Z = tbRichTextView.getRichText().Z();
                                int i6 = 0;
                                int i7 = -1;
                                while (i6 < Z.size()) {
                                    if (Z.get(i6) != null) {
                                        arrayList.add(Z.get(i6).getSrc());
                                        if (i7 == i5 && str != null && str.equals(Z.get(i6).getSrc())) {
                                            i7 = i6;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        String src = Z.get(i6).getSrc();
                                        imageUrlData.imageUrl = src;
                                        imageUrlData.imageThumbUrl = src;
                                        if (z1.k0()) {
                                            i4 = 17;
                                        } else {
                                            i4 = 18;
                                        }
                                        imageUrlData.urlThumbType = i4;
                                        imageUrlData.originalUrl = Z.get(i6).getSrc();
                                        imageUrlData.isLongPic = Z.get(i6).c0();
                                        concurrentHashMap.put(Z.get(i6).getSrc(), imageUrlData);
                                    }
                                    i6++;
                                    i5 = -1;
                                }
                                i3 = i7;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.A(arrayList);
                                builder.E(i3);
                                builder.F(false);
                                builder.O(eVar.f);
                                builder.I(this.a.a.Q().K1());
                                builder.y(concurrentHashMap);
                                builder.K(true);
                                builder.N(false);
                                if (this.a.a.Q() != null) {
                                    builder.J(this.a.a.Q().c1());
                                    builder.D(this.a.a.Q().getFromForumId());
                                    if (this.a.a.Q().z1() != null) {
                                        builder.Q(this.a.a.Q().z1().M());
                                    }
                                }
                                ImageViewerConfig x = builder.x(this.a.a.getPageContext().getPageActivity());
                                x.getIntent().putExtra("from", "pb");
                                this.a.a.sendMessage(new CustomMessage(2010000, x));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            }
                        }
                        i3 = -1;
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList);
                        builder2.E(i3);
                        builder2.F(false);
                        builder2.O(eVar.f);
                        builder2.I(this.a.a.Q().K1());
                        builder2.y(concurrentHashMap);
                        builder2.K(true);
                        builder2.N(false);
                        if (this.a.a.Q() != null) {
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.X().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = rv8.a(r.X().get(this.a.c));
                            int i8 = 0;
                            while (true) {
                                if (i8 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i8).equals(a)) {
                                    eVar.j = i8;
                                    arrayList2.add(a);
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (r.getPostId() != 0 && (F1 = this.a.a.F1()) != null) {
                                ArrayList<in> a2 = F1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<in> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        in next = it.next();
                                        if ((next instanceof pp9) && r.getPostId() == gg.g(((pp9) next).N(), 0L)) {
                                            v29.b(this.a.a.Q().z1(), (pp9) next, ((pp9) next).d0, 8, 3);
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
                            builder3.I(this.a.a.Q().K1());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a.Q() != null) {
                                builder3.J(this.a.a.Q().c1());
                                builder3.D(this.a.a.Q().getFromForumId());
                                if (this.a.a.Q().z1() != null) {
                                    builder3.Q(this.a.a.Q().z1().M());
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
                        builder4.I(this.a.a.Q().K1());
                        builder4.N(false);
                        builder4.O(eVar.f);
                        builder4.z(eVar.f);
                        builder4.G(false);
                        if (this.a.a.Q() != null) {
                            builder4.J(this.a.a.Q().c1());
                            builder4.D(this.a.a.Q().getFromForumId());
                            if (this.a.a.Q().z1() != null) {
                                builder4.Q(this.a.a.Q().z1().M());
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
    public class b implements uw8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f39 a;

        @Override // com.baidu.tieba.uw8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.uw8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(f39 f39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f39Var;
        }

        @Override // com.baidu.tieba.uw8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091dc6) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.j4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09014e) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof pp9)) {
                                return false;
                            }
                            pp9 pp9Var = (pp9) obj;
                            if (!TextUtils.isEmpty(pp9Var.r()) && iw4.c().g()) {
                                return this.a.n(pp9Var.N());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0919a4) {
                            if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.a.q((SparseArray) view2.getTag(R.id.tag_from));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = null;
                            if (view2.getTag() instanceof SparseArray) {
                                sparseArray = (SparseArray) view2.getTag();
                            }
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.q(sparseArray);
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.J4();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public f39(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new uw8(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.N();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().c0();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return false;
            }
            return tbRichTextData.d0().d0();
        }
        return invokeL.booleanValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return null;
            }
            return tbRichTextData.d0().Y();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.d0() == null) {
                return 0L;
            }
            return tbRichTextData.d0().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void e(qv8 qv8Var, ArrayList<pp9> arrayList) {
        List<pp9> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, qv8Var, arrayList) == null) && qv8Var != null && qv8Var.R() != null && qv8Var.R().a != null && (list = qv8Var.R().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<pp9> it = arrayList.iterator();
                while (it.hasNext()) {
                    pp9 next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            pp9 pp9Var = (pp9) it2.next();
                            if (pp9Var != null && !TextUtils.isEmpty(next.N()) && !TextUtils.isEmpty(pp9Var.N()) && next.N().equals(pp9Var.N())) {
                                arrayList2.add(pp9Var);
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
        }
    }

    public final TbRichText f(ArrayList<pp9> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText a0 = arrayList.get(i2).a0();
                    if (a0 != null && (X = a0.X()) != null) {
                        int size = X.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (X.get(i4) != null && X.get(i4).getType() == 8) {
                                i3++;
                                if (!X.get(i4).d0().W().equals(str) && !X.get(i4).d0().X().equals(str)) {
                                    if (i3 > i) {
                                        break;
                                    }
                                } else {
                                    int i5 = (int) ii.i(TbadkCoreApplication.getInst());
                                    int width = X.get(i4).d0().getWidth() * i5;
                                    int height = X.get(i4).d0().getHeight() * i5;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return a0;
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
        boolean z;
        TbRichTextImageInfo d0;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.X().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.X().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int i7 = (int) ii.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.d0().getWidth() * i7;
                        int height = tbRichTextData.d0().getHeight() * i7;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.d0().b0()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = rv8.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (d0 = tbRichTextData.d0()) != null) {
                                        String W = d0.W();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            W = d0.X();
                                        } else {
                                            qv8 qv8Var = null;
                                            BaseVideoPBReplyFragment baseVideoPBReplyFragment = this.a;
                                            if (baseVideoPBReplyFragment != null && baseVideoPBReplyFragment.Q() != null && this.a.Q().z1() != null) {
                                                qv8Var = this.a.Q().z1();
                                            }
                                            if (qv8Var != null && qv8Var.k0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = W;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.imageThumbUrl = W;
                                        imageUrlData.originalUrl = k(tbRichTextData);
                                        imageUrlData.originalSize = l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                        imageUrlData.isLongPic = h(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = gg.g(this.a.Q().S1(), -1L);
                                        imageUrlData.mIsReserver = this.a.Q().K1();
                                        imageUrlData.mIsSeeHost = this.a.Q().c1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a2, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.d) {
                                    i4++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i5 <= i2) {
                                i4--;
                            }
                        }
                    }
                }
                return i4;
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public TbRichTextView.a0 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (TbRichTextView.a0) invokeV.objValue;
    }

    public uw8 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (uw8) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String s = f55.m().s("bubble_link", "");
            if (StringUtils.isNull(s)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                pt4.x(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.editor_privilege), s + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o(String str, int i, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048586, this, str, i, eVar) != null) || eVar == null) {
            return;
        }
        qv8 z1 = this.a.Q().z1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.X().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.d0().b0()) {
            eVar.h = false;
            String a2 = rv8.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (z1 != null && z1.k0()) {
                    i3 = 17;
                } else {
                    i3 = 18;
                }
                imageUrlData.urlType = i3;
            }
            imageUrlData.urlThumbType = imageUrlData.urlType;
            imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalUrl = k(tbRichTextData);
            imageUrlData.originalSize = l(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
            imageUrlData.isLongPic = h(tbRichTextData);
            imageUrlData.postId = r.getPostId();
            imageUrlData.mIsReserver = this.a.Q().K1();
            imageUrlData.mIsSeeHost = this.a.Q().c1();
            eVar.b.put(a2, imageUrlData);
            if (z1 != null) {
                if (z1.k() != null) {
                    eVar.c = z1.k().getName();
                    eVar.d = z1.k().getId();
                }
                if (z1.M() != null) {
                    eVar.e = z1.M().getId();
                }
                if (z1.r() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = gg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = z1.F().size();
        this.d = false;
        eVar.j = -1;
        if (z1.i() != null) {
            i2 = g(z1.i().a0(), r, i, i, eVar.a, eVar.b);
        } else {
            i2 = i;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < size; i5++) {
            pp9 pp9Var = z1.F().get(i5);
            if (pp9Var.N() == null || z1.i() == null || z1.i().N() == null || !pp9Var.N().equals(z1.i().N())) {
                i4 = g(pp9Var.a0(), r, i4, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (z1 != null) {
            if (z1.k() != null) {
                eVar.c = z1.k().getName();
                eVar.d = z1.k().getId();
            }
            if (z1.M() != null) {
                eVar.e = z1.M().getId();
            }
            if (z1.r() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i4;
    }

    public AbsPbActivity.e p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String str2 = null;
            if (this.a.Q() != null && this.a.Q().z1() != null && this.a.Q().z1().F() != null && this.a.Q().z1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.Q().z1().F().size()) {
                        if (str.equals(this.a.Q().z1().F().get(i).N())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                pp9 pp9Var = this.a.Q().z1().F().get(i);
                if (pp9Var.a0() != null && pp9Var.a0().X() != null) {
                    Iterator<TbRichTextData> it = pp9Var.a0().X().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.d0() != null) {
                                str2 = next.d0().W();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    rv8.b(pp9Var, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        pp9 pp9Var;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof pp9) || (pp9Var = (pp9) sparseArray.get(R.id.tag_clip_board)) == null || this.a.Q() == null || this.a.Q().z1() == null || pp9Var.D() == 1) {
            return;
        }
        String S1 = this.a.Q().S1();
        String N = pp9Var.N();
        if (this.a.Q().z1() != null) {
            i = this.a.Q().z1().U();
        } else {
            i = 0;
        }
        AbsPbActivity.e p = p(N);
        if (p == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        SmallTailInfo h0 = pp9Var.h0();
        AntiData c = this.a.Q().z1().c();
        if (pp9Var.p() != null) {
            arrayList = pp9Var.p().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(S1, N, "pb", true, true, null, false, null, i, h0, c, false, arrayList, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.Q().y1());
        addBigImageData.setFromFrsForumId(this.a.Q().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.Q().X1());
        addBigImageData.setKeyFromForumId(this.a.Q().getForumId());
        addBigImageData.setBjhData(this.a.Q().R0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.Q() == null || this.a.Q().z1() == null || str == null || i < 0) {
                return null;
            }
            qv8 z1 = this.a.Q().z1();
            if (z1.i() != null) {
                ArrayList<pp9> arrayList = new ArrayList<>();
                arrayList.add(z1.i());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<pp9> F = z1.F();
                e(z1, F);
                return f(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
