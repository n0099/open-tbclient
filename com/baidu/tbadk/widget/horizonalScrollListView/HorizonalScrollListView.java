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
    private LinearLayout bnO;
    private final ArrayList<a> bnP;
    private View.OnClickListener bnQ;
    private View bnR;
    private String bnS;
    private String bnT;
    private CustomMessageListener bnU;
    private CustomMessageListener bnV;
    private View.OnClickListener bnW;
    private View.OnClickListener bnX;
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
            if (this.bnV != null) {
                this.bnV.setTag(this.mTag);
            }
            if (this.bnU != null) {
                this.bnU.setTag(this.mTag);
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
        this.bnS = str;
        this.bnT = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.bnP = new ArrayList<>();
        this.mSkinType = 3;
        this.bnQ = null;
        this.mTag = null;
        this.bnU = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bnV = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnS)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnS).y("obj_type", 1).aB(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aH(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cM(str, valueOf);
                    }
                }
            }
        };
        this.bnX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnT)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bnT).aB(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnP = new ArrayList<>();
        this.mSkinType = 3;
        this.bnQ = null;
        this.mTag = null;
        this.bnU = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bnV = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnS)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnS).y("obj_type", 1).aB(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aH(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cM(str, valueOf);
                    }
                }
            }
        };
        this.bnX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnT)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bnT).aB(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnP = new ArrayList<>();
        this.mSkinType = 3;
        this.bnQ = null;
        this.mTag = null;
        this.bnU = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bnV = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnS)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnS).y("obj_type", 1).aB(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aH(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cM(str, valueOf);
                    }
                }
            }
        };
        this.bnX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnT)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bnT).aB(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.bnO = new LinearLayout(context);
        this.bnO.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.bnO.setOrientation(0);
        addView(this.bnO);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.H(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int H = v.H(this.bnP);
            int H2 = v.H(list);
            if (H > H2) {
                for (int i = 0; i < H - H2; i++) {
                    q.a aVar = (q.a) v.d(this.bnP, i);
                    if (aVar != null) {
                        this.bnO.removeView(aVar.getView());
                    }
                    this.bnP.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < H2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.d(list, i2);
                a aVar3 = (a) v.d(this.bnP, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View oH = oH();
                    if (oH != null) {
                        a aVar4 = new a(oH);
                        this.bnP.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.bnO.addView(oH);
                    }
                }
                if (i2 == H2 - 1) {
                    a(this.bnP.get(H2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.bnU);
            this.mTbPageContext.registerListener(this.bnV);
            if (getTag() != null) {
                this.bnU.setTag(getTag());
                this.bnV.setTag(getTag());
            }
            ej(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bnR = aVar.getView();
            aVar.bof.setVisibility(8);
            aVar.bod.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.recommend_frs_hot_thread_more));
            aVar.boe.setVisibility(8);
            aVar.boc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.boc, e.f.icon_pic_more);
            al.c(aVar.bod, e.d.cp_cont_b, 1);
            al.i(aVar.boc, e.f.selector_load_more_bg);
            this.bnR.setClickable(true);
            this.bnR.setOnClickListener(this.bnQ);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bnQ = onClickListener;
    }

    public View getLastItemView() {
        return this.bnR;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bof.setClickable(true);
            aVar2.bof.setOnClickListener(this.bnW);
            view.setClickable(true);
            view.setOnClickListener(this.bnX);
        }
    }

    private View oH() {
        return View.inflate(this.mTbPageContext.getPageActivity(), e.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.boc.setTag(aVar.forumAvatar);
            aVar2.boc.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bod.setText(aVar.forumName);
            aVar2.bod.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.boe.setDefaultBgResource(0);
            aVar2.boe.setDefaultResource(0);
            aVar2.bof.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bof.setTag(e.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(e.g.tag_forum_name, aVar.forumName);
            a(aVar2.bof, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.boe.setVisibility(0);
                    al.c(aVar2.boe, e.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.boe.setVisibility(0);
                    al.c(aVar2.boe, e.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.boe.setVisibility(0);
                    al.c(aVar2.boe, e.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.boe.setVisibility(8);
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
            entelechyUserLikeButton.bL(z);
        }
    }

    public void ej(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.bnP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bnR != null) {
                BarImageView barImageView = (BarImageView) this.bnR.findViewById(e.g.forum_avatar);
                al.i(barImageView, e.f.selector_load_more_bg);
                al.c(barImageView, e.f.icon_pic_more);
                al.c((TextView) this.bnR.findViewById(e.g.m_forum_name_textview), e.d.cp_cont_b, 1);
            }
            int H = v.H(this.bnP);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < H) {
                    a aVar = (a) v.d(this.bnP, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.boe, e.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.boe, e.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.boe, e.f.icon_grade_shaitu3);
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
            if (aVar.bof.getTag(e.g.forum_follow) != null && (aVar.bof.getTag(e.g.forum_follow) instanceof Boolean)) {
                a(aVar.bof, ((Boolean) aVar.bof.getTag(e.g.forum_follow)).booleanValue());
            }
            al.c(aVar.bod, e.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        Iterator<a> it = this.bnP.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bod.getTag(e.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bof;
                if (((Long) next.bod.getTag(e.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public BarImageView boc;
        public TextView bod;
        public TbImageView boe;
        public EntelechyUserLikeButton bof;

        public a(View view) {
            super(view);
            this.boc = null;
            this.bod = null;
            this.boe = null;
            this.bof = null;
            this.boc = (BarImageView) view.findViewById(e.g.forum_avatar);
            this.boc.setGifIconSupport(false);
            this.bod = (TextView) view.findViewById(e.g.m_forum_name_textview);
            this.boe = (TbImageView) view.findViewById(e.g.hot_rank);
            this.bof = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        }
    }
}
