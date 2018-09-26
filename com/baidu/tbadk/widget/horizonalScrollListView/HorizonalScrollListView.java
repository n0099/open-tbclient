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
/* loaded from: classes2.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private String beA;
    private CustomMessageListener beB;
    private CustomMessageListener beC;
    private View.OnClickListener beD;
    private View.OnClickListener beE;
    private LinearLayout bev;
    private final ArrayList<a> bew;
    private View.OnClickListener bex;
    private View bey;
    private String bez;
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
            if (this.beC != null) {
                this.beC.setTag(this.mTag);
            }
            if (this.beB != null) {
                this.beB.setTag(this.mTag);
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
        this.bez = str;
        this.beA = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.bew = new ArrayList<>();
        this.mSkinType = 3;
        this.bex = null;
        this.mTag = null;
        this.beB = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.beC = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.beD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bA(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bw(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bez)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bez).w("obj_type", 1).al(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void j(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cu(str, valueOf);
                    }
                }
            }
        };
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bw(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.beA)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.beA).al(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bB(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bew = new ArrayList<>();
        this.mSkinType = 3;
        this.bex = null;
        this.mTag = null;
        this.beB = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.beC = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.beD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bA(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bw(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bez)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bez).w("obj_type", 1).al(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void j(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cu(str, valueOf);
                    }
                }
            }
        };
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bw(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.beA)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.beA).al(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bB(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bew = new ArrayList<>();
        this.mSkinType = 3;
        this.bex = null;
        this.mTag = null;
        this.beB = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.beC = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.beD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bA(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bw(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bez)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bez).w("obj_type", 1).al(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void j(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.am(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cu(str, valueOf);
                    }
                }
            }
        };
        this.beE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bw(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.beA)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.beA).al(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        bB(context);
    }

    private void bB(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.bev = new LinearLayout(context);
        this.bev.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.bev.setOrientation(0);
        addView(this.bev);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.y(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int y = v.y(this.bew);
            int y2 = v.y(list);
            if (y > y2) {
                for (int i = 0; i < y - y2; i++) {
                    q.a aVar = (q.a) v.d(this.bew, i);
                    if (aVar != null) {
                        this.bev.removeView(aVar.getView());
                    }
                    this.bew.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < y2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.d(list, i2);
                a aVar3 = (a) v.d(this.bew, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View ov = ov();
                    if (ov != null) {
                        a aVar4 = new a(ov);
                        this.bew.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.bev.addView(ov);
                    }
                }
                if (i2 == y2 - 1) {
                    a(this.bew.get(y2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.beB);
            this.mTbPageContext.registerListener(this.beC);
            if (getTag() != null) {
                this.beB.setTag(getTag());
                this.beC.setTag(getTag());
            }
            dx(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bey = aVar.getView();
            aVar.beM.setVisibility(8);
            aVar.beK.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.recommend_frs_hot_thread_more));
            aVar.beL.setVisibility(8);
            aVar.beJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.beJ, e.f.icon_pic_more);
            al.c(aVar.beK, e.d.cp_cont_b, 1);
            al.i(aVar.beJ, e.f.selector_load_more_bg);
            this.bey.setClickable(true);
            this.bey.setOnClickListener(this.bex);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bex = onClickListener;
    }

    public View getLastItemView() {
        return this.bey;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.beM.setClickable(true);
            aVar2.beM.setOnClickListener(this.beD);
            view.setClickable(true);
            view.setOnClickListener(this.beE);
        }
    }

    private View ov() {
        return View.inflate(this.mTbPageContext.getPageActivity(), e.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.beJ.setTag(aVar.forumAvatar);
            aVar2.beJ.startLoad(aVar.forumAvatar, 10, false);
            aVar2.beK.setText(aVar.forumName);
            aVar2.beK.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.beL.setDefaultBgResource(0);
            aVar2.beL.setDefaultResource(0);
            aVar2.beM.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.beM.setTag(e.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(e.g.tag_forum_name, aVar.forumName);
            a(aVar2.beM, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.beL.setVisibility(0);
                    al.c(aVar2.beL, e.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.beL.setVisibility(0);
                    al.c(aVar2.beL, e.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.beL.setVisibility(0);
                    al.c(aVar2.beL, e.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.beL.setVisibility(8);
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
            entelechyUserLikeButton.bi(z);
        }
    }

    public void dx(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.bew.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bey != null) {
                BarImageView barImageView = (BarImageView) this.bey.findViewById(e.g.forum_avatar);
                al.i(barImageView, e.f.selector_load_more_bg);
                al.c(barImageView, e.f.icon_pic_more);
                al.c((TextView) this.bey.findViewById(e.g.m_forum_name_textview), e.d.cp_cont_b, 1);
            }
            int y = v.y(this.bew);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < y) {
                    a aVar = (a) v.d(this.bew, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.beL, e.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.beL, e.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.beL, e.f.icon_grade_shaitu3);
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
            if (aVar.beM.getTag(e.g.forum_follow) != null && (aVar.beM.getTag(e.g.forum_follow) instanceof Boolean)) {
                a(aVar.beM, ((Boolean) aVar.beM.getTag(e.g.forum_follow)).booleanValue());
            }
            al.c(aVar.beK, e.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<a> it = this.bew.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.beK.getTag(e.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.beM;
                if (((Long) next.beK.getTag(e.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public BarImageView beJ;
        public TextView beK;
        public TbImageView beL;
        public EntelechyUserLikeButton beM;

        public a(View view) {
            super(view);
            this.beJ = null;
            this.beK = null;
            this.beL = null;
            this.beM = null;
            this.beJ = (BarImageView) view.findViewById(e.g.forum_avatar);
            this.beJ.setGifIconSupport(false);
            this.beK = (TextView) view.findViewById(e.g.m_forum_name_textview);
            this.beL = (TbImageView) view.findViewById(e.g.hot_rank);
            this.beM = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        }
    }
}
