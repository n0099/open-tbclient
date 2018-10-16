package com.baidu.tbadk.widget.horizonalScrollListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout biN;
    private final ArrayList<a> biO;
    private View.OnClickListener biP;
    private View biQ;
    private String biR;
    private String biS;
    private CustomMessageListener biT;
    private CustomMessageListener biU;
    private View.OnClickListener biV;
    private View.OnClickListener biW;
    private String mFrom;
    private int mSkinType;
    private BdUniqueId mTag;
    private TbPageContext<?> mTbPageContext;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
        if (this.mTag != null) {
            if (this.biU != null) {
                this.biU.setTag(this.mTag);
            }
            if (this.biT != null) {
                this.biT.setTag(this.mTag);
            }
        }
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setStatKey(String str, String str2) {
        this.biR = str;
        this.biS = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.biO = new ArrayList<>();
        this.mSkinType = 3;
        this.biP = null;
        this.mTag = null;
        this.biT = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.biU = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.biV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bI(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.biR)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.biR).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cF(str, valueOf);
                    }
                }
            }
        };
        this.biW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.biS)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.biS).ax(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bJ(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biO = new ArrayList<>();
        this.mSkinType = 3;
        this.biP = null;
        this.mTag = null;
        this.biT = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.biU = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.biV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bI(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.biR)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.biR).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cF(str, valueOf);
                    }
                }
            }
        };
        this.biW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.biS)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.biS).ax(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bJ(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biO = new ArrayList<>();
        this.mSkinType = 3;
        this.biP = null;
        this.mTag = null;
        this.biT = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.biU = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.biV = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bI(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.biR)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.biR).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cF(str, valueOf);
                    }
                }
            }
        };
        this.biW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.biS)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.biS).ax(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bJ(context);
    }

    private void bJ(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.biN = new LinearLayout(context);
        this.biN.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.biN.setOrientation(0);
        addView(this.biN);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.I(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int I = v.I(this.biO);
            int I2 = v.I(list);
            if (I > I2) {
                for (int i = 0; i < I - I2; i++) {
                    q.a aVar = (q.a) v.d(this.biO, i);
                    if (aVar != null) {
                        this.biN.removeView(aVar.getView());
                    }
                    this.biO.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < I2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.d(list, i2);
                a aVar3 = (a) v.d(this.biO, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View oG = oG();
                    if (oG != null) {
                        a aVar4 = new a(oG);
                        this.biO.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.biN.addView(oG);
                    }
                }
                if (i2 == I2 - 1) {
                    a(this.biO.get(I2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.biT);
            this.mTbPageContext.registerListener(this.biU);
            if (getTag() != null) {
                this.biT.setTag(getTag());
                this.biU.setTag(getTag());
            }
            dH(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.biQ = aVar.getView();
            aVar.bje.setVisibility(8);
            aVar.bjc.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.recommend_frs_hot_thread_more));
            aVar.bjd.setVisibility(8);
            aVar.bjb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.bjb, e.f.icon_pic_more);
            al.c(aVar.bjc, e.d.cp_cont_b, 1);
            al.i(aVar.bjb, e.f.selector_load_more_bg);
            this.biQ.setClickable(true);
            this.biQ.setOnClickListener(this.biP);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.biP = onClickListener;
    }

    public View getLastItemView() {
        return this.biQ;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bje.setClickable(true);
            aVar2.bje.setOnClickListener(this.biV);
            view.setClickable(true);
            view.setOnClickListener(this.biW);
        }
    }

    private View oG() {
        return View.inflate(this.mTbPageContext.getPageActivity(), e.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bjb.setTag(aVar.forumAvatar);
            aVar2.bjb.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bjc.setText(aVar.forumName);
            aVar2.bjc.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bjd.setDefaultBgResource(0);
            aVar2.bjd.setDefaultResource(0);
            aVar2.bje.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bje.setTag(e.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(e.g.tag_forum_name, aVar.forumName);
            a(aVar2.bje, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bjd.setVisibility(0);
                    al.c(aVar2.bjd, e.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bjd.setVisibility(0);
                    al.c(aVar2.bjd, e.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bjd.setVisibility(0);
                    al.c(aVar2.bjd, e.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bjd.setVisibility(8);
                    break;
            }
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(e.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.bs(z);
        }
    }

    public void dH(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.biO.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.biQ != null) {
                BarImageView barImageView = (BarImageView) this.biQ.findViewById(e.g.forum_avatar);
                al.i(barImageView, e.f.selector_load_more_bg);
                al.c(barImageView, e.f.icon_pic_more);
                al.c((TextView) this.biQ.findViewById(e.g.m_forum_name_textview), e.d.cp_cont_b, 1);
            }
            int I = v.I(this.biO);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < I) {
                    a aVar = (a) v.d(this.biO, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.bjd, e.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.bjd, e.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.bjd, e.f.icon_grade_shaitu3);
                                continue;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            this.mSkinType = i;
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(a aVar, int i) {
        if (aVar != null && aVar.getView() != null) {
            if (aVar.bje.getTag(e.g.forum_follow) != null && (aVar.bje.getTag(e.g.forum_follow) instanceof Boolean)) {
                a(aVar.bje, ((Boolean) aVar.bje.getTag(e.g.forum_follow)).booleanValue());
            }
            al.c(aVar.bjc, e.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<a> it = this.biO.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bjc.getTag(e.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bje;
                if (((Long) next.bjc.getTag(e.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public BarImageView bjb;
        public TextView bjc;
        public TbImageView bjd;
        public EntelechyUserLikeButton bje;

        public a(View view) {
            super(view);
            this.bjb = null;
            this.bjc = null;
            this.bjd = null;
            this.bje = null;
            this.bjb = (BarImageView) view.findViewById(e.g.forum_avatar);
            this.bjb.setGifIconSupport(false);
            this.bjc = (TextView) view.findViewById(e.g.m_forum_name_textview);
            this.bjd = (TbImageView) view.findViewById(e.g.hot_rank);
            this.bje = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        }
    }
}
