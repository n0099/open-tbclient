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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout aZZ;
    private final ArrayList<a> baa;
    private View.OnClickListener bab;
    private View bac;
    private String bad;
    private String bae;
    private CustomMessageListener baf;
    private CustomMessageListener bag;
    private View.OnClickListener bah;
    private View.OnClickListener bai;
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
            if (this.bag != null) {
                this.bag.setTag(this.mTag);
            }
            if (this.baf != null) {
                this.baf.setTag(this.mTag);
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
        this.bad = str;
        this.bae = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.baa = new ArrayList<>();
        this.mSkinType = 3;
        this.bab = null;
        this.mTag = null;
        this.baf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bag = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bah = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bc(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bad)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bad).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tE(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cj(str, valueOf);
                    }
                }
            }
        };
        this.bai = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ao.bc(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bae)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bae).ah(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aW(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baa = new ArrayList<>();
        this.mSkinType = 3;
        this.bab = null;
        this.mTag = null;
        this.baf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bag = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bah = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bc(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bad)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bad).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tE(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cj(str, valueOf);
                    }
                }
            }
        };
        this.bai = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ao.bc(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bae)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bae).ah(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aW(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baa = new ArrayList<>();
        this.mSkinType = 3;
        this.bab = null;
        this.mTag = null;
        this.baf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bag = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bah = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bc(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bad)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bad).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tE(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cj(str, valueOf);
                    }
                }
            }
        };
        this.bai = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ao.bc(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bae)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bae).ah(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aW(context);
    }

    private void aW(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aZZ = new LinearLayout(context);
        this.aZZ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aZZ.setOrientation(0);
        addView(this.aZZ);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (w.y(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int y = w.y(this.baa);
            int y2 = w.y(list);
            if (y > y2) {
                for (int i = 0; i < y - y2; i++) {
                    q.a aVar = (q.a) w.c(this.baa, i);
                    if (aVar != null) {
                        this.aZZ.removeView(aVar.getView());
                    }
                    this.baa.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < y2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) w.c(list, i2);
                a aVar3 = (a) w.c(this.baa, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View nn = nn();
                    if (nn != null) {
                        a aVar4 = new a(nn);
                        this.baa.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.aZZ.addView(nn);
                    }
                }
                if (i2 == y2 - 1) {
                    a(this.baa.get(y2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.baf);
            this.mTbPageContext.registerListener(this.bag);
            if (getTag() != null) {
                this.baf.setTag(getTag());
                this.bag.setTag(getTag());
            }
            dk(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bac = aVar.getView();
            aVar.baq.setVisibility(8);
            aVar.bao.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.recommend_frs_hot_thread_more));
            aVar.bap.setVisibility(8);
            aVar.ban.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.ban, d.f.icon_pic_more);
            al.c(aVar.bao, d.C0141d.cp_cont_b, 1);
            al.i(aVar.ban, d.f.selector_load_more_bg);
            this.bac.setClickable(true);
            this.bac.setOnClickListener(this.bab);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bab = onClickListener;
    }

    public View getLastItemView() {
        return this.bac;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.baq.setClickable(true);
            aVar2.baq.setOnClickListener(this.bah);
            view.setClickable(true);
            view.setOnClickListener(this.bai);
        }
    }

    private View nn() {
        return View.inflate(this.mTbPageContext.getPageActivity(), d.i.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.ban.setTag(aVar.forumAvatar);
            aVar2.ban.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bao.setText(aVar.forumName);
            aVar2.bao.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bap.setDefaultBgResource(0);
            aVar2.bap.setDefaultResource(0);
            aVar2.baq.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.baq.setTag(d.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(d.g.tag_forum_name, aVar.forumName);
            a(aVar2.baq, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bap.setVisibility(0);
                    al.c(aVar2.bap, d.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bap.setVisibility(0);
                    al.c(aVar2.bap, d.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bap.setVisibility(0);
                    al.c(aVar2.bap, d.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bap.setVisibility(8);
                    break;
            }
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aU(z);
        }
    }

    public void dk(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.baa.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bac != null) {
                BarImageView barImageView = (BarImageView) this.bac.findViewById(d.g.forum_avatar);
                al.i(barImageView, d.f.selector_load_more_bg);
                al.c(barImageView, d.f.icon_pic_more);
                al.c((TextView) this.bac.findViewById(d.g.m_forum_name_textview), d.C0141d.cp_cont_b, 1);
            }
            int y = w.y(this.baa);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < y) {
                    a aVar = (a) w.c(this.baa, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.bap, d.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.bap, d.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.bap, d.f.icon_grade_shaitu3);
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
            if (aVar.baq.getTag(d.g.forum_follow) != null && (aVar.baq.getTag(d.g.forum_follow) instanceof Boolean)) {
                a(aVar.baq, ((Boolean) aVar.baq.getTag(d.g.forum_follow)).booleanValue());
            }
            al.c(aVar.bao, d.C0141d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        Iterator<a> it = this.baa.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bao.getTag(d.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.baq;
                if (((Long) next.bao.getTag(d.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public BarImageView ban;
        public TextView bao;
        public TbImageView bap;
        public EntelechyUserLikeButton baq;

        public a(View view) {
            super(view);
            this.ban = null;
            this.bao = null;
            this.bap = null;
            this.baq = null;
            this.ban = (BarImageView) view.findViewById(d.g.forum_avatar);
            this.ban.setGifIconSupport(false);
            this.bao = (TextView) view.findViewById(d.g.m_forum_name_textview);
            this.bap = (TbImageView) view.findViewById(d.g.hot_rank);
            this.baq = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        }
    }
}
