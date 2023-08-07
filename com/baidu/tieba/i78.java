package com.baidu.tieba;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class i78 extends dm6<a78> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public a78 j;
    public ClickableHeaderImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public AgreeView o;
    public TextView p;
    public ImageView q;
    public TbRichTextView r;
    public ConstrainImageGroup s;
    public RelativeLayout t;
    public View u;
    public TbImageView v;
    public TextView w;
    public View x;
    public boolean y;
    public int z;

    @Override // com.baidu.tieba.dm6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.layout.obfuscated_res_0x7f0d099c : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements iz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkedList a;
        public final /* synthetic */ ThreadData b;
        public final /* synthetic */ i78 c;

        public a(i78 i78Var, LinkedList linkedList, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i78Var, linkedList, threadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i78Var;
            this.a = linkedList;
            this.b = threadData;
        }

        @Override // com.baidu.tieba.iz5
        public void a(View view2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (z) {
                    this.c.u();
                } else {
                    this.c.G(view2, this.a, i, this.b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i78(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = true;
        this.z = 3;
        this.i = tbPageContext;
        t();
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            TiebaStatic.log(new StatisticItem("c13356").param("obj_locate", str).param("tid", this.j.b.getTid()).param("topic_id", this.j.c).param("obj_type", String.valueOf(this.j.e)));
        }
    }

    public final void A(a78 a78Var, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, a78Var, threadData) == null) {
            if (this.j.e == 1) {
                this.u.setVisibility(0);
                this.t.setVisibility(8);
                String title = threadData.getTitle();
                if (StringUtils.isNull(title)) {
                    this.u.setVisibility(8);
                    return;
                }
                this.u.setVisibility(0);
                this.w.setText(title);
                String str = null;
                if (ListUtils.getCount(threadData.getMedias()) != 0 && !ListUtils.isEmpty(a78Var.b.getMedias())) {
                    Iterator<MediaData> it = a78Var.b.getMedias().iterator();
                    while (it.hasNext()) {
                        MediaData next = it.next();
                        if (next != null && next.getType() == 3) {
                            str = next.getPicUrl();
                            if (StringUtils.isNull(str)) {
                                str = next.getSmallUrl();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getThumbnails_url();
                            }
                            if (StringUtils.isNull(str)) {
                                str = next.getSrc_pic();
                            }
                            if (!StringUtils.isNull(str)) {
                                break;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    SkinManager.setImageResource(this.v, R.drawable.pic_frs_topic_shareinone);
                    return;
                }
                this.v.setPlaceHolder(1);
                this.v.startLoad(str, 10, false);
                return;
            }
            this.u.setVisibility(8);
            this.t.setVisibility(0);
            E(a78Var);
        }
    }

    public final void B(qba qbaVar, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qbaVar, threadData) == null) {
            if (this.j.e == 1) {
                this.r.setVisibility(0);
                this.r.setText(qbaVar.e0());
                return;
            }
            List<PbContent> firstFloorList = threadData.getFirstFloorList();
            if (ListUtils.getCount(firstFloorList) > 0) {
                this.r.setVisibility(0);
                this.r.setText(TbRichTextView.d0(firstFloorList, false, threadData));
                return;
            }
            SpannableString parseAbstract = threadData.parseAbstract();
            if (parseAbstract != null && !StringUtils.isNull(parseAbstract.toString())) {
                this.r.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", parseAbstract);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                this.r.setText(TbRichTextView.Z(jSONArray, false));
                return;
            }
            this.r.setVisibility(8);
        }
    }

    public void C(ag<TbImageView> agVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, agVar) == null) && (constrainImageGroup = this.s) != null) {
            constrainImageGroup.setImageViewPool(agVar);
        }
    }

    public void D(ag<ConstrainImageLayout> agVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, agVar) == null) && (constrainImageGroup = this.s) != null) {
            constrainImageGroup.setConstrainLayoutPool(agVar);
        }
    }

    public final void F(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            l(bdUniqueId);
            ConstrainImageGroup constrainImageGroup = this.s;
            if (constrainImageGroup != null) {
                constrainImageGroup.setPageUniqueId(bdUniqueId);
            }
        }
    }

    public final void E(a78 a78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a78Var) == null) {
            ThreadData threadData = a78Var.b;
            ArrayList<MediaData> medias = threadData.getMedias();
            if (b05.c().g() && ListUtils.getCount(medias) != 0) {
                LinkedList linkedList = new LinkedList();
                for (int i = 0; i < medias.size(); i++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(medias, i);
                    if (mediaData != null && mediaData.getType() == 3) {
                        linkedList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(linkedList) > 0) {
                    this.t.setVisibility(0);
                    this.s.setFromCDN(this.y);
                    this.s.setImageClickListener(new a(this, linkedList, threadData));
                    this.s.setImageMediaList(linkedList);
                    return;
                }
                this.t.setVisibility(8);
                return;
            }
            this.t.setVisibility(8);
        }
    }

    public final void G(View view2, List<MediaData> list, int i, ThreadData threadData) {
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048582, this, view2, list, i, threadData) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                BdUtilHelper.showToast(this.b.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
            for (MediaData mediaData : list) {
                if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                    arrayList.add(mediaData.getSrc_pic());
                    if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        if (this.y) {
                            i2 = 13;
                        } else {
                            i2 = 14;
                        }
                        imageUrlData.urlType = i2;
                        String picUrl = mediaData.getPicUrl();
                        imageUrlData.imageUrl = picUrl;
                        imageUrlData.urlThumbType = imageUrlData.urlType;
                        imageUrlData.imageThumbUrl = picUrl;
                        imageUrlData.originalUrl = mediaData.getOriginalUrl();
                        imageUrlData.originalSize = mediaData.getOriginalSize();
                        imageUrlData.isLongPic = mediaData.isLongPic();
                        imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                        imageUrlData.threadId = JavaTypesHelper.toLong(threadData.getTid(), -1L);
                        imageUrlData.postId = mediaData.getPostId();
                        concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                for (MediaData mediaData2 : list) {
                    if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                        arrayList.add(mediaData2.getPicUrl());
                    }
                }
            }
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            ImageViewerConfig.Builder isCDN = builder.setData(arrayList).setIndex(i).setForumName(threadData.getForum_name()).setPostId(threadData.getFirst_post_id()).setForumId(String.valueOf(threadData.getFid())).setThreadId(threadData.getTid()).setIsCDN(this.y);
            if (arrayList.size() > 0) {
                str = arrayList.get(0);
            } else {
                str = "";
            }
            isCDN.setLastId(str).setIsReserve(true).setAssistUrls(concurrentHashMap).setIsShowAd(true).setThreadData(threadData).setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view2));
            ImageViewerConfig bulid = builder.bulid(this.b.getPageActivity());
            if (this.h == 2) {
                bulid.getIntent().putExtra("from", "index");
            } else {
                bulid.getIntent().putExtra("from", "other");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, bulid));
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.b;
            historyMessage.threadId = threadData.getId();
            historyMessage.threadName = threadData.getTitle();
            historyMessage.forumName = threadData.getForum_name();
            historyMessage.postID = threadData.getFirstPostId();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    @Override // com.baidu.tieba.dm6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, tbPageContext, i) == null) && this.z != i && this.j != null) {
            this.z = i;
            this.k.setSkinType(i);
            a78 a78Var = this.j;
            if (a78Var.f) {
                int i2 = a78Var.d;
                if (i2 == 1) {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_agree_red);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (i2 == 2) {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_disagree_blue);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    SkinManager.setImageResource(this.m, R.drawable.label_topic_eat_black);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0107);
            if (this.q != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, null);
            }
            this.o.Q(i);
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setBackgroundShapeDrawable(this.u, BdUtilHelper.getDimens(this.i.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            this.s.b();
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a78 a78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (a78Var = this.j) != null && a78Var.b != null) {
            if (view2 == this.r) {
                if (a78Var.e == 1) {
                    x();
                } else {
                    u();
                }
                s("1");
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 == this.l) {
                    y();
                    return;
                }
                u();
                s("2");
                return;
            }
            if (this.j.e == 1) {
                x();
            } else {
                u();
            }
            s("3");
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View h = h();
            this.k = (ClickableHeaderImageView) h.findViewById(R.id.obfuscated_res_0x7f090631);
            this.m = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090635);
            this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090632);
            this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09062f);
            TbRichTextView tbRichTextView = (TbRichTextView) h.findViewById(R.id.obfuscated_res_0x7f090633);
            this.r = tbRichTextView;
            tbRichTextView.setClickable(true);
            this.r.setTextEllipsize(TextUtils.TruncateAt.END);
            this.r.setMaxLines(2);
            j06 j06Var = new j06();
            j06Var.x(BdUtilHelper.getDimens(getContext(), R.dimen.tbds44));
            j06Var.p(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
            this.r.setLayoutStrategy(j06Var);
            this.t = (RelativeLayout) h.findViewById(R.id.obfuscated_res_0x7f092625);
            this.s = (ConstrainImageGroup) h.findViewById(R.id.obfuscated_res_0x7f090630);
            this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
            fz5 fz5Var = new fz5(3);
            fz5Var.d(1.0d);
            this.s.setImageProcessor(fz5Var);
            AgreeView agreeView = (AgreeView) h.findViewById(R.id.obfuscated_res_0x7f09062c);
            this.o = agreeView;
            agreeView.A();
            this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092617);
            this.q = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092618);
            this.u = h.findViewById(R.id.obfuscated_res_0x7f09062e);
            TbImageView tbImageView = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f090637);
            this.v = tbImageView;
            tbImageView.setRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds6));
            this.v.setConrers(5);
            this.v.setDrawCorner(true);
            this.w = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090638);
            this.x = h.findViewById(R.id.obfuscated_res_0x7f09062d);
            this.l.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
        }
    }

    public void u() {
        a78 a78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (a78Var = this.j) != null && a78Var.b != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.i.getPageActivity()).createFromThreadCfg(this.j.b, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.j.b.getFid()));
            addLocateParam.setFrom("from_personalize");
            addLocateParam.setForumName(this.j.b.getForum_name());
            addLocateParam.setStartFrom(this.h);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            nm6.a(this.j.b.getTid());
            this.b.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String format = String.format("%1$s", this.j.b.getTopAgreePost().S());
            String valueOf = String.valueOf(this.j.b.getTid());
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.i.getPageActivity());
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(valueOf, format + "", 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    public final void y() {
        a78 a78Var;
        ThreadData threadData;
        MetaData author;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (a78Var = this.j) != null && (threadData = a78Var.b) != null) {
            if (a78Var.e == 1 && threadData.getTopAgreePost() != null) {
                author = threadData.getTopAgreePost().r();
            } else {
                author = threadData.getAuthor();
            }
            if (author != null && !StringUtils.isNull(author.getName_show()) && !StringUtils.isNull(author.getUserId())) {
                long j = JavaTypesHelper.toLong(author.getUserId(), 0L);
                if (j == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                    z = true;
                } else {
                    z = false;
                }
                if (threadData.getThreadVideoInfo() != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, z, author.isBigV(), z2, "topic_detail");
                createNormalConfig.setSourceTid(threadData.getTid());
                createNormalConfig.setSourceNid(threadData.getNid());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dm6
    /* renamed from: z */
    public void i(a78 a78Var) {
        String name_show;
        String formatTime;
        int reply_num;
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, a78Var) == null) && a78Var != null && a78Var.b != null) {
            this.j = a78Var;
            j(this.i, TbadkCoreApplication.getInst().getSkinType());
            ThreadData threadData = this.j.b;
            qba topAgreePost = threadData.getTopAgreePost();
            if (topAgreePost == null) {
                return;
            }
            this.k.setPlaceHolder(1);
            if (this.j.e == 1) {
                this.k.setData(threadData, false, true);
            } else {
                this.k.setData(threadData, false, false);
            }
            this.k.setIsRound(true);
            this.k.setBorderWidth(2);
            this.k.setDrawBorder(true);
            this.k.setPageId(this.i.getUniqueId());
            if (this.j.f) {
                this.m.setVisibility(0);
                int i = this.j.d;
                if (i == 1) {
                    this.m.setImageResource(R.drawable.label_topic_agree_red);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (i == 2) {
                    this.m.setImageResource(R.drawable.label_topic_disagree_blue);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    this.m.setImageResource(R.drawable.label_topic_eat_black);
                    this.k.setBorderColor(this.i.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            } else {
                this.m.setVisibility(8);
            }
            if (this.j.e == 1) {
                name_show = topAgreePost.r().getName_show();
                formatTime = StringHelper.getFormatTime(topAgreePost.p0());
                reply_num = topAgreePost.k0();
            } else {
                name_show = threadData.getAuthor().getName_show();
                formatTime = StringHelper.getFormatTime(threadData.getCreateTime());
                reply_num = threadData.getReply_num();
            }
            if (!StringUtils.isNull(name_show)) {
                this.l.setText(StringHelper.cutChineseAndEnglishWithSuffix(name_show, 14, "..."));
            }
            if (StringUtils.isNull(threadData.getForum_name())) {
                this.n.setText(formatTime);
            } else {
                this.n.setText(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f051c), StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 10, "..."), formatTime));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            String numFormatOverWan = StringHelper.numFormatOverWan(reply_num);
            if (reply_num > 0) {
                this.p.setVisibility(0);
                this.p.setText(numFormatOverWan);
            } else {
                this.p.setText(this.i.getString(R.string.action_comment_default));
                this.p.setVisibility(0);
            }
            if (this.j.e == 1) {
                agreeData = topAgreePost.o();
                agreeData.objType = 1;
            } else {
                agreeData = threadData.getAgreeData();
                agreeData.objType = 3;
            }
            agreeData.threadId = threadData.getTid();
            this.o.setData(agreeData);
            this.o.setTopicId(String.valueOf(this.j.c));
            B(topAgreePost, threadData);
            A(a78Var, threadData);
            F(f());
        }
    }
}
