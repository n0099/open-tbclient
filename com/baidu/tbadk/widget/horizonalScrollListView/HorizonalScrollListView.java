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
    private LinearLayout bmZ;
    private final ArrayList<a> bna;
    private View.OnClickListener bnb;
    private View bnc;
    private String bnd;
    private String bne;
    private CustomMessageListener bnf;
    private CustomMessageListener bng;
    private View.OnClickListener bnh;
    private View.OnClickListener bni;
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
            if (this.bng != null) {
                this.bng.setTag(this.mTag);
            }
            if (this.bnf != null) {
                this.bnf.setTag(this.mTag);
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
        this.bnd = str;
        this.bne = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.bna = new ArrayList<>();
        this.mSkinType = 3;
        this.bnb = null;
        this.mTag = null;
        this.bnf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bng = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnh = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnd)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnd).x("obj_type", 1).aA(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aj(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cK(str, valueOf);
                    }
                }
            }
        };
        this.bni = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bne)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bne).aA(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bna = new ArrayList<>();
        this.mSkinType = 3;
        this.bnb = null;
        this.mTag = null;
        this.bnf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bng = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnh = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnd)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnd).x("obj_type", 1).aA(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aj(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cK(str, valueOf);
                    }
                }
            }
        };
        this.bni = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bne)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bne).aA(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bna = new ArrayList<>();
        this.mSkinType = 3;
        this.bnb = null;
        this.mTag = null;
        this.bnf = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bng = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.c(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bnh = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(e.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ao.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bnd)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.bnd).x("obj_type", 1).aA(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aj(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cK(str, valueOf);
                    }
                }
            }
        };
        this.bni = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(e.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(e.g.tag_forum_id));
                if (ao.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bne)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.bne).aA(ImageViewerConfig.FORUM_ID, valueOf));
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
        this.bmZ = new LinearLayout(context);
        this.bmZ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.bmZ.setOrientation(0);
        addView(this.bmZ);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.H(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int H = v.H(this.bna);
            int H2 = v.H(list);
            if (H > H2) {
                for (int i = 0; i < H - H2; i++) {
                    q.a aVar = (q.a) v.d(this.bna, i);
                    if (aVar != null) {
                        this.bmZ.removeView(aVar.getView());
                    }
                    this.bna.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < H2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.d(list, i2);
                a aVar3 = (a) v.d(this.bna, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View oD = oD();
                    if (oD != null) {
                        a aVar4 = new a(oD);
                        this.bna.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.bmZ.addView(oD);
                    }
                }
                if (i2 == H2 - 1) {
                    a(this.bna.get(H2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.bnf);
            this.mTbPageContext.registerListener(this.bng);
            if (getTag() != null) {
                this.bnf.setTag(getTag());
                this.bng.setTag(getTag());
            }
            ej(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bnc = aVar.getView();
            aVar.bnq.setVisibility(8);
            aVar.bno.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.recommend_frs_hot_thread_more));
            aVar.bnp.setVisibility(8);
            aVar.bnn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.bnn, e.f.icon_pic_more);
            al.c(aVar.bno, e.d.cp_cont_b, 1);
            al.i(aVar.bnn, e.f.selector_load_more_bg);
            this.bnc.setClickable(true);
            this.bnc.setOnClickListener(this.bnb);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bnb = onClickListener;
    }

    public View getLastItemView() {
        return this.bnc;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bnq.setClickable(true);
            aVar2.bnq.setOnClickListener(this.bnh);
            view.setClickable(true);
            view.setOnClickListener(this.bni);
        }
    }

    private View oD() {
        return View.inflate(this.mTbPageContext.getPageActivity(), e.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bnn.setTag(aVar.forumAvatar);
            aVar2.bnn.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bno.setText(aVar.forumName);
            aVar2.bno.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bnp.setDefaultBgResource(0);
            aVar2.bnp.setDefaultResource(0);
            aVar2.bnq.setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bnq.setTag(e.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(e.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(e.g.tag_forum_name, aVar.forumName);
            a(aVar2.bnq, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bnp.setVisibility(0);
                    al.c(aVar2.bnp, e.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bnp.setVisibility(0);
                    al.c(aVar2.bnp, e.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bnp.setVisibility(0);
                    al.c(aVar2.bnp, e.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bnp.setVisibility(8);
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
            entelechyUserLikeButton.bK(z);
        }
    }

    public void ej(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.bna.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bnc != null) {
                BarImageView barImageView = (BarImageView) this.bnc.findViewById(e.g.forum_avatar);
                al.i(barImageView, e.f.selector_load_more_bg);
                al.c(barImageView, e.f.icon_pic_more);
                al.c((TextView) this.bnc.findViewById(e.g.m_forum_name_textview), e.d.cp_cont_b, 1);
            }
            int H = v.H(this.bna);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < H) {
                    a aVar = (a) v.d(this.bna, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.bnp, e.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.bnp, e.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.bnp, e.f.icon_grade_shaitu3);
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
            if (aVar.bnq.getTag(e.g.forum_follow) != null && (aVar.bnq.getTag(e.g.forum_follow) instanceof Boolean)) {
                a(aVar.bnq, ((Boolean) aVar.bnq.getTag(e.g.forum_follow)).booleanValue());
            }
            al.c(aVar.bno, e.d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, boolean z) {
        Iterator<a> it = this.bna.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bno.getTag(e.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bnq;
                if (((Long) next.bno.getTag(e.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public BarImageView bnn;
        public TextView bno;
        public TbImageView bnp;
        public EntelechyUserLikeButton bnq;

        public a(View view) {
            super(view);
            this.bnn = null;
            this.bno = null;
            this.bnp = null;
            this.bnq = null;
            this.bnn = (BarImageView) view.findViewById(e.g.forum_avatar);
            this.bnn.setGifIconSupport(false);
            this.bno = (TextView) view.findViewById(e.g.m_forum_name_textview);
            this.bnp = (TbImageView) view.findViewById(e.g.hot_rank);
            this.bnq = (EntelechyUserLikeButton) view.findViewById(e.g.forum_add_love);
        }
    }
}
