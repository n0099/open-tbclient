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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout cyo;
    private final ArrayList<a> cyp;
    private View.OnClickListener cyq;
    private View cyr;
    private String cys;
    private String cyt;
    private CustomMessageListener cyu;
    private CustomMessageListener cyv;
    private View.OnClickListener cyw;
    private View.OnClickListener cyx;
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
            if (this.cyv != null) {
                this.cyv.setTag(this.mTag);
            }
            if (this.cyu != null) {
                this.cyu.setTag(this.mTag);
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
        this.cys = str;
        this.cyt = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cyp = new ArrayList<>();
        this.mSkinType = 3;
        this.cyq = null;
        this.mTag = null;
        this.cyu = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cyv = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cyw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cys)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cys).T("obj_type", 1).bJ(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aD(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aU(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dW(str, valueOf);
                    }
                }
            }
        };
        this.cyx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cyt)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cyt).bJ(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyp = new ArrayList<>();
        this.mSkinType = 3;
        this.cyq = null;
        this.mTag = null;
        this.cyu = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cyv = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cyw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cys)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cys).T("obj_type", 1).bJ(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aD(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aU(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dW(str, valueOf);
                    }
                }
            }
        };
        this.cyx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cyt)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cyt).bJ(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyp = new ArrayList<>();
        this.mSkinType = 3;
        this.cyq = null;
        this.mTag = null;
        this.cyu = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cyv = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cyw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cZ(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bv(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cys)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cys).T("obj_type", 1).bJ(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aD(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aU(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.dW(str, valueOf);
                    }
                }
            }
        };
        this.cyx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bv(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cyt)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cyt).bJ(ImageViewerConfig.FORUM_ID, valueOf));
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
        this.cyo = new LinearLayout(context);
        this.cyo.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cyo.setOrientation(0);
        addView(this.cyo);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.S(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int S = v.S(this.cyp);
            int S2 = v.S(list);
            if (S > S2) {
                for (int i = 0; i < S - S2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.c(this.cyp, i);
                    if (aVar != null) {
                        this.cyo.removeView(aVar.getView());
                    }
                    this.cyp.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < S2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.c(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.c(this.cyp, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View oM = oM();
                    if (oM != null) {
                        a aVar4 = new a(oM);
                        this.cyp.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cyo.addView(oM);
                    }
                }
                if (i2 == S2 - 1) {
                    a(this.cyp.get(S2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cyu);
            this.mTbPageContext.registerListener(this.cyv);
            if (getTag() != null) {
                this.cyu.setTag(getTag());
                this.cyv.setTag(getTag());
            }
            hM(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cyr = aVar.getView();
            aVar.cyF.setVisibility(8);
            aVar.cyD.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.recommend_frs_hot_thread_more));
            aVar.cyE.setVisibility(8);
            aVar.cyC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.cyC, d.f.icon_pic_more);
            al.d(aVar.cyD, d.C0277d.cp_cont_b, 1);
            al.k(aVar.cyC, d.f.selector_load_more_bg);
            this.cyr.setClickable(true);
            this.cyr.setOnClickListener(this.cyq);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cyq = onClickListener;
    }

    public View getLastItemView() {
        return this.cyr;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cyF.setClickable(true);
            aVar2.cyF.setOnClickListener(this.cyw);
            view.setClickable(true);
            view.setOnClickListener(this.cyx);
        }
    }

    private View oM() {
        return View.inflate(this.mTbPageContext.getPageActivity(), d.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cyC.setTag(aVar.forumAvatar);
            aVar2.cyC.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cyD.setText(aVar.forumName);
            aVar2.cyD.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cyE.setDefaultBgResource(0);
            aVar2.cyE.setDefaultResource(0);
            aVar2.cyF.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cyF.setTag(d.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(d.g.tag_forum_name, aVar.forumName);
            a(aVar2.cyF, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cyE.setVisibility(0);
                    al.c(aVar2.cyE, d.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cyE.setVisibility(0);
                    al.c(aVar2.cyE, d.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cyE.setVisibility(0);
                    al.c(aVar2.cyE, d.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cyE.setVisibility(8);
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
            entelechyUserLikeButton.dU(z);
        }
    }

    public void hM(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cyp.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cyr != null) {
                BarImageView barImageView = (BarImageView) this.cyr.findViewById(d.g.forum_avatar);
                al.k(barImageView, d.f.selector_load_more_bg);
                al.c(barImageView, d.f.icon_pic_more);
                al.d((TextView) this.cyr.findViewById(d.g.m_forum_name_textview), d.C0277d.cp_cont_b, 1);
            }
            int S = com.baidu.tbadk.core.util.v.S(this.cyp);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < S) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.c(this.cyp, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.cyE, d.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.cyE, d.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.cyE, d.f.icon_grade_shaitu3);
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
            if (aVar.cyF.getTag(d.g.forum_follow) != null && (aVar.cyF.getTag(d.g.forum_follow) instanceof Boolean)) {
                a(aVar.cyF, ((Boolean) aVar.cyF.getTag(d.g.forum_follow)).booleanValue());
            }
            al.d(aVar.cyD, d.C0277d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cyp.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cyD.getTag(d.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cyF;
                if (((Long) next.cyD.getTag(d.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cyC;
        public TextView cyD;
        public TbImageView cyE;
        public EntelechyUserLikeButton cyF;

        public a(View view) {
            super(view);
            this.cyC = null;
            this.cyD = null;
            this.cyE = null;
            this.cyF = null;
            this.cyC = (BarImageView) view.findViewById(d.g.forum_avatar);
            this.cyC.setGifIconSupport(false);
            this.cyD = (TextView) view.findViewById(d.g.m_forum_name_textview);
            this.cyE = (TbImageView) view.findViewById(d.g.hot_rank);
            this.cyF = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        }
    }
}
