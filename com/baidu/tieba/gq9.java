package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.fj9;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class gq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public int c;
    public boolean d;
    public final TbRichTextView.z e;
    public fj9 f;

    /* loaded from: classes6.dex */
    public class a implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq9 a;

        public a(gq9 gq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq9Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v32, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01c7 A[Catch: Exception -> 0x04e7, TryCatch #0 {Exception -> 0x04e7, blocks: (B:5:0x0014, B:9:0x004a, B:12:0x00d8, B:14:0x00de, B:16:0x00f1, B:18:0x00fd, B:20:0x0107, B:21:0x0111, B:23:0x0117, B:25:0x011d, B:28:0x012e, B:31:0x013f, B:35:0x015d, B:36:0x0184, B:39:0x018b, B:41:0x01c7, B:43:0x01f3, B:44:0x0206, B:46:0x023b, B:48:0x023f, B:50:0x0258, B:51:0x0267, B:53:0x02c9, B:55:0x02f5, B:56:0x0308, B:57:0x033e, B:60:0x0347, B:62:0x034f, B:65:0x0361, B:66:0x037b, B:68:0x0383, B:70:0x0391, B:71:0x0397, B:72:0x039a, B:74:0x03a4, B:76:0x03ae, B:78:0x03b8, B:79:0x03bc, B:81:0x03c2, B:83:0x03cc, B:85:0x03e0, B:87:0x03fd, B:89:0x0408, B:90:0x0417, B:92:0x046f, B:94:0x049b, B:95:0x04ae), top: B:104:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            hq9 U1;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.W().M1());
                    statisticItem.param("fid", this.a.a.W().getForumId());
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
                    statisticItem2.param("fid", this.a.a.W().getForumId());
                    statisticItem2.param("tid", this.a.a.W().M1());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("post_id", this.a.a.W().Q0());
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 10);
                    statisticItem2.param("obj_locate", this.a.b.E3());
                    TiebaStatic.log(statisticItem2);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.o(str, i, eVar);
                    yh9 s1 = this.a.a.W().s1();
                    if (s1 != null && s1.j0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        int i5 = -1;
                        if (view2.getParent() instanceof TbRichTextView) {
                            TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                            if (tbRichTextView.getRichText() != null && tbRichTextView.getRichText().R() != null) {
                                ArrayList<TbRichTextImageInfo> R = tbRichTextView.getRichText().R();
                                int i6 = 0;
                                int i7 = -1;
                                while (i6 < R.size()) {
                                    if (R.get(i6) != null) {
                                        arrayList.add(R.get(i6).getSrc());
                                        if (i7 == i5 && str != null && str.equals(R.get(i6).getSrc())) {
                                            i7 = i6;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        String src = R.get(i6).getSrc();
                                        imageUrlData.imageUrl = src;
                                        imageUrlData.imageThumbUrl = src;
                                        if (s1.m0()) {
                                            i4 = 17;
                                        } else {
                                            i4 = 18;
                                        }
                                        imageUrlData.urlThumbType = i4;
                                        imageUrlData.originalUrl = R.get(i6).getSrc();
                                        imageUrlData.isLongPic = R.get(i6).U();
                                        concurrentHashMap.put(R.get(i6).getSrc(), imageUrlData);
                                    }
                                    i6++;
                                    i5 = -1;
                                }
                                i3 = i7;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.W().E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                                if (this.a.a.W() != null) {
                                    builder.setIsSeeHost(this.a.a.W().V0());
                                    builder.setFromForumId(this.a.a.W().getFromForumId());
                                    if (this.a.a.W().s1() != null) {
                                        builder.setThreadData(this.a.a.W().s1().O());
                                    }
                                }
                                ImageViewerConfig bulid = builder.bulid(this.a.a.getPageContext().getPageActivity());
                                bulid.getIntent().putExtra("from", "pb");
                                this.a.a.sendMessage(new CustomMessage(2010000, bulid));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            }
                        }
                        i3 = -1;
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.W().E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                        if (this.a.a.W() != null) {
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (eVar.h) {
                        TbRichText r = this.a.r(str, i);
                        if (r != null && this.a.c >= 0 && this.a.c < r.P().size()) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            String a = zh9.a(r.P().get(this.a.c));
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
                            if (r.getPostId() != 0 && (U1 = this.a.a.U1()) != null) {
                                ArrayList<bn> a2 = U1.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<bn> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        bn next = it.next();
                                        if ((next instanceof zfa) && r.getPostId() == JavaTypesHelper.toLong(((zfa) next).S(), 0L)) {
                                            wp9.b(this.a.a.W().s1(), (zfa) next, ((zfa) next).e0, 8, 3);
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
                            builder3.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setAssistUrls(concurrentHashMap2).setNeedBroadCaset(false).setIsReserve(this.a.a.W().E1()).setPostId(eVar.f).setBjhPostId(eVar.f);
                            if (this.a.a.W() != null) {
                                builder3.setIsSeeHost(this.a.a.W().V0());
                                builder3.setFromForumId(this.a.a.W().getFromForumId());
                                if (this.a.a.W().s1() != null) {
                                    builder3.setThreadData(this.a.a.W().s1().O());
                                }
                            }
                            ImageViewerConfig bulid3 = builder3.bulid(this.a.a.getPageContext().getPageActivity());
                            bulid3.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, bulid3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.b.get(str3));
                        }
                        ImageViewerConfig.Builder builder4 = new ImageViewerConfig.Builder();
                        builder4.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setAssistUrls(concurrentHashMap3).setIsReserve(this.a.a.W().E1()).setNeedBroadCaset(false).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.a.W() != null) {
                            builder4.setIsSeeHost(this.a.a.W().V0());
                            builder4.setFromForumId(this.a.a.W().getFromForumId());
                            if (this.a.a.W().s1() != null) {
                                builder4.setThreadData(this.a.a.W().s1().O());
                            }
                        }
                        ImageViewerConfig bulid4 = builder4.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid4.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid4));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fj9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq9 a;

        @Override // com.baidu.tieba.fj9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.fj9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(gq9 gq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq9Var;
        }

        @Override // com.baidu.tieba.fj9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f27) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.y4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09015e) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof zfa)) {
                                return false;
                            }
                            zfa zfaVar = (zfa) obj;
                            if (!TextUtils.isEmpty(zfaVar.u()) && h05.c().g()) {
                                return this.a.n(zfaVar.S());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091acd) {
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
                        absVideoPbFragment3.Y4();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public gq9(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.f = new fj9(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.Q();
    }

    public final boolean h(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().U();
        }
        return invokeL.booleanValue;
    }

    public final boolean i(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return false;
            }
            return tbRichTextData.V().V();
        }
        return invokeL.booleanValue;
    }

    public final String k(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return null;
            }
            return tbRichTextData.V().Q();
        }
        return (String) invokeL.objValue;
    }

    public final long l(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.V() == null) {
                return 0L;
            }
            return tbRichTextData.V().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void e(yh9 yh9Var, ArrayList<zfa> arrayList) {
        List<zfa> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, yh9Var, arrayList) == null) && yh9Var != null && yh9Var.T() != null && yh9Var.T().a != null && (list = yh9Var.T().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<zfa> it = arrayList.iterator();
                while (it.hasNext()) {
                    zfa next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            zfa zfaVar = (zfa) it2.next();
                            if (zfaVar != null && !TextUtils.isEmpty(next.S()) && !TextUtils.isEmpty(zfaVar.S()) && next.S().equals(zfaVar.S())) {
                                arrayList2.add(zfaVar);
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

    public final TbRichText f(ArrayList<zfa> arrayList, String str, int i) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, i)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    TbRichText e0 = arrayList.get(i2).e0();
                    if (e0 != null && (P = e0.P()) != null) {
                        int size = P.size();
                        int i3 = -1;
                        for (int i4 = 0; i4 < size; i4++) {
                            if (P.get(i4) != null && P.get(i4).getType() == 8) {
                                i3++;
                                if (!P.get(i4).V().O().equals(str) && !P.get(i4).V().P().equals(str)) {
                                    if (i3 > i) {
                                        break;
                                    }
                                } else {
                                    int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                                    int width = P.get(i4).V().getWidth() * equipmentDensity;
                                    int height = P.get(i4).V().getHeight() * equipmentDensity;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.c = i4;
                                    return e0;
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
        TbRichTextImageInfo V;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i), Integer.valueOf(i2), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.d = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.P().size();
                int i4 = i;
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    TbRichTextData tbRichTextData = tbRichText.P().get(i6);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.V().getWidth() * equipmentDensity;
                        int height = tbRichTextData.V().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.V().T()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = zh9.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (V = tbRichTextData.V()) != null) {
                                        String O = V.O();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            O = V.P();
                                        } else {
                                            yh9 yh9Var = null;
                                            BaseVideoPBReplyFragment baseVideoPBReplyFragment = this.a;
                                            if (baseVideoPBReplyFragment != null && baseVideoPBReplyFragment.W() != null && this.a.W().s1() != null) {
                                                yh9Var = this.a.W().s1();
                                            }
                                            if (yh9Var != null && yh9Var.m0()) {
                                                i3 = 17;
                                            } else {
                                                i3 = 18;
                                            }
                                            imageUrlData.urlType = i3;
                                        }
                                        imageUrlData.imageUrl = O;
                                        imageUrlData.urlThumbType = imageUrlData.urlType;
                                        imageUrlData.imageThumbUrl = O;
                                        imageUrlData.originalUrl = k(tbRichTextData);
                                        imageUrlData.originalSize = l(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = i(tbRichTextData);
                                        imageUrlData.isLongPic = h(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = JavaTypesHelper.toLong(this.a.W().M1(), -1L);
                                        imageUrlData.mIsReserver = this.a.W().E1();
                                        imageUrlData.mIsSeeHost = this.a.W().V0();
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

    public TbRichTextView.z j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (TbRichTextView.z) invokeV.objValue;
    }

    public fj9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (fj9) invokeV.objValue;
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (baseVideoPBReplyFragment = this.a) == null || !ViewHelper.checkUpIsLogin(baseVideoPBReplyFragment.getPageContext().getPageActivity())) {
                return false;
            }
            String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.a.getPageContext().getPageActivity())));
            } else {
                BrowserHelper.startWebActivity(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
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
        yh9 s1 = this.a.W().s1();
        TbRichText r = r(str, i);
        if (r == null || (tbRichTextData = r.P().get(this.c)) == null) {
            return;
        }
        eVar.f = String.valueOf(r.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.V().T()) {
            eVar.h = false;
            String a2 = zh9.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (s1 != null && s1.m0()) {
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
            imageUrlData.mIsReserver = this.a.W().E1();
            imageUrlData.mIsSeeHost = this.a.W().V0();
            eVar.b.put(a2, imageUrlData);
            if (s1 != null) {
                if (s1.k() != null) {
                    eVar.c = s1.k().getName();
                    eVar.d = s1.k().getId();
                }
                if (s1.O() != null) {
                    eVar.e = s1.O().getId();
                }
                if (s1.r() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = JavaTypesHelper.toLong(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = s1.F().size();
        this.d = false;
        eVar.j = -1;
        if (s1.i() != null) {
            i2 = g(s1.i().e0(), r, i, i, eVar.a, eVar.b);
        } else {
            i2 = i;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < size; i5++) {
            zfa zfaVar = s1.F().get(i5);
            if (zfaVar.S() == null || s1.i() == null || s1.i().S() == null || !zfaVar.S().equals(s1.i().S())) {
                i4 = g(zfaVar.e0(), r, i4, i, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (s1 != null) {
            if (s1.k() != null) {
                eVar.c = s1.k().getName();
                eVar.d = s1.k().getId();
            }
            if (s1.O() != null) {
                eVar.e = s1.O().getId();
            }
            if (s1.r() == 1) {
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
            if (this.a.W() != null && this.a.W().s1() != null && this.a.W().s1().F() != null && this.a.W().s1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.W().s1().F().size()) {
                        if (str.equals(this.a.W().s1().F().get(i).S())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                zfa zfaVar = this.a.W().s1().F().get(i);
                if (zfaVar.e0() != null && zfaVar.e0().P() != null) {
                    Iterator<TbRichTextData> it = zfaVar.e0().P().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().O();
                            }
                        }
                    }
                    o(str2, 0, eVar);
                    zh9.b(zfaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void q(SparseArray<Object> sparseArray) {
        zfa zfaVar;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof zfa) || (zfaVar = (zfa) sparseArray.get(R.id.tag_clip_board)) == null || this.a.W() == null || this.a.W().s1() == null || zfaVar.I() == 1) {
            return;
        }
        String M1 = this.a.W().M1();
        String S = zfaVar.S();
        if (this.a.W().s1() != null) {
            i = this.a.W().s1().W();
        } else {
            i = 0;
        }
        AbsPbActivity.e p = p(S);
        if (p == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        SmallTailInfo l0 = zfaVar.l0();
        AntiData c = this.a.W().s1().c();
        if (zfaVar.r() != null) {
            arrayList = zfaVar.r().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, S, "pb", true, true, null, false, null, i, l0, c, false, arrayList, 0).addBigImageData(p.a, p.b, p.g, p.j);
        addBigImageData.setKeyPageStartFrom(this.a.W().r1());
        addBigImageData.setFromFrsForumId(this.a.W().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.W().R1());
        addBigImageData.setKeyFromForumId(this.a.W().getForumId());
        addBigImageData.setBjhData(this.a.W().J0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final TbRichText r(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            TbRichText tbRichText = null;
            if (this.a.W() == null || this.a.W().s1() == null || str == null || i < 0) {
                return null;
            }
            yh9 s1 = this.a.W().s1();
            if (s1.i() != null) {
                ArrayList<zfa> arrayList = new ArrayList<>();
                arrayList.add(s1.i());
                tbRichText = f(arrayList, str, i);
            }
            if (tbRichText == null) {
                ArrayList<zfa> F = s1.F();
                e(s1, F);
                return f(F, str, i);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
