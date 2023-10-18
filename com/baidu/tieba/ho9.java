package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment;
import com.baidu.tieba.tg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ho9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseVideoPBReplyFragment a;
    public AbsVideoPbFragment b;
    public final TbRichTextView.z c;
    public tg9 d;

    /* loaded from: classes6.dex */
    public class a implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho9 a;

        public a(ho9 ho9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho9Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x01cd A[Catch: Exception -> 0x04eb, TryCatch #0 {Exception -> 0x04eb, blocks: (B:5:0x0014, B:9:0x004a, B:12:0x00de, B:14:0x00e4, B:16:0x00f7, B:18:0x0103, B:20:0x010d, B:21:0x0117, B:23:0x011d, B:25:0x0123, B:28:0x0134, B:31:0x0145, B:35:0x0163, B:36:0x018a, B:39:0x0191, B:41:0x01cd, B:43:0x01f9, B:44:0x020c, B:46:0x0241, B:48:0x0245, B:50:0x0260, B:51:0x0271, B:53:0x02d3, B:55:0x02ff, B:56:0x0312, B:57:0x0348, B:60:0x0357, B:62:0x035d, B:65:0x0369, B:66:0x037d, B:68:0x0385, B:70:0x0393, B:71:0x0399, B:72:0x039c, B:74:0x03a6, B:76:0x03b0, B:78:0x03ba, B:79:0x03be, B:81:0x03c4, B:83:0x03ce, B:85:0x03e2, B:87:0x03ff, B:89:0x040a, B:90:0x041b, B:92:0x0473, B:94:0x049f, B:95:0x04b2), top: B:104:0x0014 }] */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            int d;
            io9 c2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.a.e0().M1());
                    statisticItem.param("fid", this.a.a.e0().getForumId());
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
                    statisticItem2.param("fid", this.a.a.e0().getForumId());
                    statisticItem2.param("tid", this.a.a.e0().M1());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("post_id", this.a.a.e0().Q0());
                    statisticItem2.param("obj_source", 1);
                    statisticItem2.param("obj_type", 10);
                    statisticItem2.param("obj_locate", this.a.b.L3());
                    TiebaStatic.log(statisticItem2);
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pic_pb", "");
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    sj9.e(this.a.a.e0(), str, i, eVar);
                    ye9 s1 = this.a.a.e0().s1();
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
                                        arrayList.add(R.get(i6).T());
                                        if (i7 == i5 && str != null && str.equals(R.get(i6).T())) {
                                            i7 = i6;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        String T2 = R.get(i6).T();
                                        imageUrlData.imageUrl = T2;
                                        imageUrlData.imageThumbUrl = T2;
                                        if (s1.m0()) {
                                            i4 = 17;
                                        } else {
                                            i4 = 18;
                                        }
                                        imageUrlData.urlThumbType = i4;
                                        imageUrlData.originalUrl = R.get(i6).T();
                                        imageUrlData.isLongPic = R.get(i6).W();
                                        concurrentHashMap.put(R.get(i6).T(), imageUrlData);
                                    }
                                    i6++;
                                    i5 = -1;
                                }
                                i3 = i7;
                                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                                builder.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.e0().E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                                if (this.a.a.e0() != null) {
                                    builder.setIsSeeHost(this.a.a.e0().V0());
                                    builder.setFromForumId(this.a.a.e0().getFromForumId());
                                    if (this.a.a.e0().s1() != null) {
                                        builder.setThreadData(this.a.a.e0().s1().O());
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
                        builder2.setData(arrayList).setIndex(i3).setIsCDN(false).setPostId(eVar.f).setIsReserve(this.a.a.e0().E1()).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false);
                        if (this.a.a.e0() != null) {
                        }
                        ImageViewerConfig bulid2 = builder2.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid2.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add((String) ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                        builder3.setData(arrayList2).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.a.get(0)).setAssistUrls(concurrentHashMap2).setIsReserve(this.a.a.e0().E1()).setNeedBroadCaset(false).setPostId(eVar.f).setBjhPostId(eVar.f).setIsCanDrag(false);
                        if (this.a.a.e0() != null) {
                            builder3.setIsSeeHost(this.a.a.e0().V0());
                            builder3.setFromForumId(this.a.a.e0().getFromForumId());
                            if (this.a.a.e0().s1() != null) {
                                builder3.setThreadData(this.a.a.e0().s1().O());
                            }
                        }
                        ImageViewerConfig bulid3 = builder3.bulid(this.a.a.getPageContext().getPageActivity());
                        bulid3.getIntent().putExtra("from", "pb");
                        this.a.a.sendMessage(new CustomMessage(2010000, bulid3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText f = sj9.f(this.a.a.e0(), str, i);
                        if (f != null && (d = sj9.d()) >= 0 && d < f.P().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = ze9.a(f.P().get(d));
                            int i8 = 0;
                            while (true) {
                                if (i8 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i8).equals(a)) {
                                    eVar.j = i8;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (f.getPostId() != 0 && (c2 = this.a.a.c2()) != null) {
                                ArrayList<yh> a2 = c2.a();
                                if (ListUtils.getCount(a2) > 0) {
                                    Iterator<yh> it = a2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        yh next = it.next();
                                        if ((next instanceof pea) && f.getPostId() == JavaTypesHelper.toLong(((pea) next).U(), 0L)) {
                                            xn9.b(this.a.a.e0().s1(), (pea) next, ((pea) next).f0, 8, 3);
                                            break;
                                        }
                                    }
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = arrayList3.get(0);
                                concurrentHashMap3.put(str3, eVar.b.get(str3));
                            }
                            ImageViewerConfig.Builder builder4 = new ImageViewerConfig.Builder();
                            builder4.setData(arrayList3).setForumName(eVar.c).setForumId(eVar.d).setThreadId(eVar.e).setIsCDN(eVar.g).setIsShowAd(true).setLastId(eVar.i).setAssistUrls(concurrentHashMap3).setNeedBroadCaset(false).setIsReserve(this.a.a.e0().E1()).setPostId(eVar.f).setBjhPostId(eVar.f);
                            if (this.a.a.e0() != null) {
                                builder4.setIsSeeHost(this.a.a.e0().V0());
                                builder4.setFromForumId(this.a.a.e0().getFromForumId());
                                if (this.a.a.e0().s1() != null) {
                                    builder4.setThreadData(this.a.a.e0().s1().O());
                                }
                            }
                            ImageViewerConfig bulid4 = builder4.bulid(this.a.a.getPageContext().getPageActivity());
                            bulid4.getIntent().putExtra("from", "pb");
                            this.a.a.sendMessage(new CustomMessage(2010000, bulid4));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ho9 a;

        @Override // com.baidu.tieba.tg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public b(ho9 ho9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ho9Var;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a.b;
                if (absVideoPbFragment != null && absVideoPbFragment.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091f39) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.b;
                            if (absVideoPbFragment2 != null && absVideoPbFragment2.F4(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09015d) {
                            if (!(view2.getTag() instanceof SparseArray)) {
                                return false;
                            }
                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                            if (!(obj instanceof pea)) {
                                return false;
                            }
                            pea peaVar = (pea) obj;
                            if (!TextUtils.isEmpty(peaVar.v()) && uu4.c().g()) {
                                return this.a.e(peaVar.U());
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091afb) {
                            if (view2.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.a.g((SparseArray) view2.getTag(R.id.tag_from));
                            }
                        } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.pb_post_header_layout) {
                            SparseArray sparseArray = null;
                            if (view2.getTag() instanceof SparseArray) {
                                sparseArray = (SparseArray) view2.getTag();
                            }
                            if (sparseArray != null) {
                                this.a.g(sparseArray);
                            } else {
                                return false;
                            }
                        }
                    }
                    AbsVideoPbFragment absVideoPbFragment3 = this.a.b;
                    if (absVideoPbFragment3 != null) {
                        absVideoPbFragment3.g5();
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public ho9(BaseVideoPBReplyFragment baseVideoPBReplyFragment) {
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
        this.c = new a(this);
        this.d = new tg9(new b(this));
        this.a = baseVideoPBReplyFragment;
        this.b = baseVideoPBReplyFragment.a0();
    }

    public TbRichTextView.z c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (TbRichTextView.z) invokeV.objValue;
    }

    public tg9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (tg9) invokeV.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        BaseVideoPBReplyFragment baseVideoPBReplyFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
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

    public AbsPbActivity.e f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String str2 = null;
            if (this.a.e0() != null && this.a.e0().s1() != null && this.a.e0().s1().F() != null && this.a.e0().s1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i = 0;
                while (true) {
                    if (i < this.a.e0().s1().F().size()) {
                        if (str.equals(this.a.e0().s1().F().get(i).U())) {
                            break;
                        }
                        i++;
                    } else {
                        i = 0;
                        break;
                    }
                }
                pea peaVar = this.a.e0().s1().F().get(i);
                if (peaVar.f0() != null && peaVar.f0().P() != null) {
                    Iterator<TbRichTextData> it = peaVar.f0().P().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.V() != null) {
                                str2 = next.V().P();
                            }
                        }
                    }
                    sj9.e(this.a.e0(), str2, 0, eVar);
                    ze9.b(peaVar, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void g(SparseArray<Object> sparseArray) {
        pea peaVar;
        int i;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, sparseArray) != null) || !this.a.checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.tag_clip_board) instanceof pea) || (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) == null || this.a.e0() == null || this.a.e0().s1() == null || peaVar.L() == 1) {
            return;
        }
        String M1 = this.a.e0().M1();
        String U = peaVar.U();
        if (this.a.e0().s1() != null) {
            i = this.a.e0().s1().W();
        } else {
            i = 0;
        }
        AbsPbActivity.e f = f(U);
        if (f == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this.a.getPageContext().getPageActivity());
        SmallTailInfo m0 = peaVar.m0();
        AntiData c = this.a.e0().s1().c();
        if (peaVar.t() != null) {
            arrayList = peaVar.t().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(M1, U, "pb", true, true, null, false, null, i, m0, c, false, arrayList, 0).addBigImageData(f.a, f.b, f.g, f.j);
        addBigImageData.setKeyPageStartFrom(this.a.e0().r1());
        addBigImageData.setFromFrsForumId(this.a.e0().getFromForumId());
        addBigImageData.setWorksInfoData(this.a.e0().R1());
        addBigImageData.setKeyFromForumId(this.a.e0().getForumId());
        addBigImageData.setBjhData(this.a.e0().J0());
        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
    }
}
