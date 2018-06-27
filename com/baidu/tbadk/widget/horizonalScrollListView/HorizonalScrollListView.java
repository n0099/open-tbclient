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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bb;
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
    private LinearLayout baV;
    private final ArrayList<a> baW;
    private View.OnClickListener baX;
    private View baY;
    private String baZ;
    private String bba;
    private CustomMessageListener bbb;
    private CustomMessageListener bbc;
    private View.OnClickListener bbd;
    private View.OnClickListener bbe;
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
            if (this.bbc != null) {
                this.bbc.setTag(this.mTag);
            }
            if (this.bbb != null) {
                this.bbb.setTag(this.mTag);
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
        this.baZ = str;
        this.bba = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.baW = new ArrayList<>();
        this.mSkinType = 3;
        this.baX = null;
        this.mTag = null;
        this.bbb = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbc = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbd = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.be(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.baZ)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.baZ).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tQ(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cn(str, valueOf);
                    }
                }
            }
        };
        this.bbe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.be(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bba)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bba).ah(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aW(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.baW = new ArrayList<>();
        this.mSkinType = 3;
        this.baX = null;
        this.mTag = null;
        this.bbb = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbc = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbd = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.be(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.baZ)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.baZ).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tQ(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cn(str, valueOf);
                    }
                }
            }
        };
        this.bbe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.be(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bba)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bba).ah(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aW(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baW = new ArrayList<>();
        this.mSkinType = 3;
        this.baX = null;
        this.mTag = null;
        this.bbb = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbc = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbd = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.be(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.baZ)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.baZ).r("obj_type", 1).ah(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tQ(likeModel.getErrorCode())) {
                                    AntiHelper.ao(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cn(str, valueOf);
                    }
                }
            }
        };
        this.bbe = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.be(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bba)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bba).ah(ImageViewerConfig.FORUM_ID, valueOf));
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
        this.baV = new LinearLayout(context);
        this.baV.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.baV.setOrientation(0);
        addView(this.baV);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (w.z(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int z = w.z(this.baW);
            int z2 = w.z(list);
            if (z > z2) {
                for (int i = 0; i < z - z2; i++) {
                    q.a aVar = (q.a) w.d(this.baW, i);
                    if (aVar != null) {
                        this.baV.removeView(aVar.getView());
                    }
                    this.baW.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < z2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) w.d(list, i2);
                a aVar3 = (a) w.d(this.baW, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View nn = nn();
                    if (nn != null) {
                        a aVar4 = new a(nn);
                        this.baW.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.baV.addView(nn);
                    }
                }
                if (i2 == z2 - 1) {
                    a(this.baW.get(z2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.bbb);
            this.mTbPageContext.registerListener(this.bbc);
            if (getTag() != null) {
                this.bbb.setTag(getTag());
                this.bbc.setTag(getTag());
            }
            dl(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.baY = aVar.getView();
            aVar.bbm.setVisibility(8);
            aVar.bbk.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.recommend_frs_hot_thread_more));
            aVar.bbl.setVisibility(8);
            aVar.bbj.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.c(aVar.bbj, d.f.icon_pic_more);
            am.c(aVar.bbk, d.C0142d.cp_cont_b, 1);
            am.i(aVar.bbj, d.f.selector_load_more_bg);
            this.baY.setClickable(true);
            this.baY.setOnClickListener(this.baX);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.baX = onClickListener;
    }

    public View getLastItemView() {
        return this.baY;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bbm.setClickable(true);
            aVar2.bbm.setOnClickListener(this.bbd);
            view.setClickable(true);
            view.setOnClickListener(this.bbe);
        }
    }

    private View nn() {
        return View.inflate(this.mTbPageContext.getPageActivity(), d.i.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bbj.setTag(aVar.forumAvatar);
            aVar2.bbj.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bbk.setText(aVar.forumName);
            aVar2.bbk.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bbl.setDefaultBgResource(0);
            aVar2.bbl.setDefaultResource(0);
            aVar2.bbm.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bbm.setTag(d.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(d.g.tag_forum_name, aVar.forumName);
            a(aVar2.bbm, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bbl.setVisibility(0);
                    am.c(aVar2.bbl, d.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bbl.setVisibility(0);
                    am.c(aVar2.bbl, d.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bbl.setVisibility(0);
                    am.c(aVar2.bbl, d.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bbl.setVisibility(8);
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
            entelechyUserLikeButton.aX(z);
        }
    }

    public void dl(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.baW.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.baY != null) {
                BarImageView barImageView = (BarImageView) this.baY.findViewById(d.g.forum_avatar);
                am.i(barImageView, d.f.selector_load_more_bg);
                am.c(barImageView, d.f.icon_pic_more);
                am.c((TextView) this.baY.findViewById(d.g.m_forum_name_textview), d.C0142d.cp_cont_b, 1);
            }
            int z = w.z(this.baW);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < z) {
                    a aVar = (a) w.d(this.baW, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.c(aVar.bbl, d.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.c(aVar.bbl, d.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.c(aVar.bbl, d.f.icon_grade_shaitu3);
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
            if (aVar.bbm.getTag(d.g.forum_follow) != null && (aVar.bbm.getTag(d.g.forum_follow) instanceof Boolean)) {
                a(aVar.bbm, ((Boolean) aVar.bbm.getTag(d.g.forum_follow)).booleanValue());
            }
            am.c(aVar.bbk, d.C0142d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        Iterator<a> it = this.baW.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bbk.getTag(d.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bbm;
                if (((Long) next.bbk.getTag(d.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public BarImageView bbj;
        public TextView bbk;
        public TbImageView bbl;
        public EntelechyUserLikeButton bbm;

        public a(View view) {
            super(view);
            this.bbj = null;
            this.bbk = null;
            this.bbl = null;
            this.bbm = null;
            this.bbj = (BarImageView) view.findViewById(d.g.forum_avatar);
            this.bbj.setGifIconSupport(false);
            this.bbk = (TextView) view.findViewById(d.g.m_forum_name_textview);
            this.bbl = (TbImageView) view.findViewById(d.g.hot_rank);
            this.bbm = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        }
    }
}
