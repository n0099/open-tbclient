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
    private View.OnClickListener bjA;
    private View bjB;
    private String bjC;
    private String bjD;
    private CustomMessageListener bjE;
    private CustomMessageListener bjF;
    private View.OnClickListener bjG;
    private View.OnClickListener bjH;
    private LinearLayout bjy;
    private final ArrayList<a> bjz;
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
            if (this.bjF != null) {
                this.bjF.setTag(this.mTag);
            }
            if (this.bjE != null) {
                this.bjE.setTag(this.mTag);
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
        this.bjC = str;
        this.bjD = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.bjz = new ArrayList<>();
        this.mSkinType = 3;
        this.bjA = null;
        this.mTag = null;
        this.bjE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bjF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bjG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bG(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bjC).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.ai(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
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
        this.bjH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bjD).ax(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjz = new ArrayList<>();
        this.mSkinType = 3;
        this.bjA = null;
        this.mTag = null;
        this.bjE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bjF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bjG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bG(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bjC).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.ai(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
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
        this.bjH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bjD).ax(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjz = new ArrayList<>();
        this.mSkinType = 3;
        this.bjA = null;
        this.mTag = null;
        this.bjE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bjF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bjG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bG(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bjC).x("obj_type", 1).ax(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.ai(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aG(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
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
        this.bjH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bjD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bjD).ax(ImageViewerConfig.FORUM_ID, valueOf));
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
        this.bjy = new LinearLayout(context);
        this.bjy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.bjy.setOrientation(0);
        addView(this.bjy);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.H(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int H = v.H(this.bjz);
            int H2 = v.H(list);
            if (H > H2) {
                for (int i = 0; i < H - H2; i++) {
                    q.a aVar = (q.a) v.d(this.bjz, i);
                    if (aVar != null) {
                        this.bjy.removeView(aVar.getView());
                    }
                    this.bjz.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < H2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.d(list, i2);
                a aVar3 = (a) v.d(this.bjz, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View oE = oE();
                    if (oE != null) {
                        a aVar4 = new a(oE);
                        this.bjz.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.bjy.addView(oE);
                    }
                }
                if (i2 == H2 - 1) {
                    a(this.bjz.get(H2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.bjE);
            this.mTbPageContext.registerListener(this.bjF);
            if (getTag() != null) {
                this.bjE.setTag(getTag());
                this.bjF.setTag(getTag());
            }
            dV(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bjB = aVar.getView();
            aVar.bjP.setVisibility(8);
            aVar.bjN.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.recommend_frs_hot_thread_more));
            aVar.bjO.setVisibility(8);
            aVar.bjM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.bjM, e.f.icon_pic_more);
            al.c(aVar.bjN, e.d.cp_cont_b, 1);
            al.i(aVar.bjM, e.f.selector_load_more_bg);
            this.bjB.setClickable(true);
            this.bjB.setOnClickListener(this.bjA);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bjA = onClickListener;
    }

    public View getLastItemView() {
        return this.bjB;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bjP.setClickable(true);
            aVar2.bjP.setOnClickListener(this.bjG);
            view.setClickable(true);
            view.setOnClickListener(this.bjH);
        }
    }

    private View oE() {
        return View.inflate(this.mTbPageContext.getPageActivity(), e.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bjM.setTag(aVar.forumAvatar);
            aVar2.bjM.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bjN.setText(aVar.forumName);
            aVar2.bjN.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bjO.setDefaultBgResource(0);
            aVar2.bjO.setDefaultResource(0);
            aVar2.bjP.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bjP.setTag(e.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(e.g.tag_forum_name, aVar.forumName);
            a(aVar2.bjP, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bjO.setVisibility(0);
                    al.c(aVar2.bjO, e.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bjO.setVisibility(0);
                    al.c(aVar2.bjO, e.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bjO.setVisibility(0);
                    al.c(aVar2.bjO, e.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bjO.setVisibility(8);
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
            entelechyUserLikeButton.bJ(z);
        }
    }

    public void dV(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.bjz.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bjB != null) {
                BarImageView barImageView = (BarImageView) this.bjB.findViewById(e.g.forum_avatar);
                al.i(barImageView, e.f.selector_load_more_bg);
                al.c(barImageView, e.f.icon_pic_more);
                al.c((TextView) this.bjB.findViewById(e.g.m_forum_name_textview), e.d.cp_cont_b, 1);
            }
            int H = v.H(this.bjz);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < H) {
                    a aVar = (a) v.d(this.bjz, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.bjO, e.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.bjO, e.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.bjO, e.f.icon_grade_shaitu3);
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
            if (aVar.bjP.getTag(e.g.forum_follow) != null && (aVar.bjP.getTag(e.g.forum_follow) instanceof Boolean)) {
                a(aVar.bjP, ((Boolean) aVar.bjP.getTag(e.g.forum_follow)).booleanValue());
            }
            al.c(aVar.bjN, e.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        Iterator<a> it = this.bjz.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bjN.getTag(e.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bjP;
                if (((Long) next.bjN.getTag(e.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public BarImageView bjM;
        public TextView bjN;
        public TbImageView bjO;
        public EntelechyUserLikeButton bjP;

        public a(View view) {
            super(view);
            this.bjM = null;
            this.bjN = null;
            this.bjO = null;
            this.bjP = null;
            this.bjM = (BarImageView) view.findViewById(e.g.forum_avatar);
            this.bjM.setGifIconSupport(false);
            this.bjN = (TextView) view.findViewById(e.g.m_forum_name_textview);
            this.bjO = (TbImageView) view.findViewById(e.g.hot_rank);
            this.bjP = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        }
    }
}
