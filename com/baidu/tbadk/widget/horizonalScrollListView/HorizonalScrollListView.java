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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private final ArrayList<a> cGA;
    private View.OnClickListener cGB;
    private View cGC;
    private String cGD;
    private String cGE;
    private CustomMessageListener cGF;
    private CustomMessageListener cGG;
    private View.OnClickListener cGH;
    private View.OnClickListener cGI;
    private LinearLayout cGz;
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
            if (this.cGG != null) {
                this.cGG.setTag(this.mTag);
            }
            if (this.cGF != null) {
                this.cGF.setTag(this.mTag);
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
        this.cGD = str;
        this.cGE = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cGA = new ArrayList<>();
        this.mSkinType = 3;
        this.cGB = null;
        this.mTag = null;
        this.cGF = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGG = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).P("obj_type", 1).bT("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ek(str, valueOf);
                    }
                }
            }
        };
        this.cGI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGE)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGE).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGA = new ArrayList<>();
        this.mSkinType = 3;
        this.cGB = null;
        this.mTag = null;
        this.cGF = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGG = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).P("obj_type", 1).bT("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ek(str, valueOf);
                    }
                }
            }
        };
        this.cGI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGE)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGE).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGA = new ArrayList<>();
        this.mSkinType = 3;
        this.cGB = null;
        this.mTag = null;
        this.cGF = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGG = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).P("obj_type", 1).bT("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.aG(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aI(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ek(str, valueOf);
                    }
                }
            }
        };
        this.cGI = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGE)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGE).bT("fid", valueOf));
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
        this.cGz = new LinearLayout(context);
        this.cGz.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cGz.setOrientation(0);
        addView(this.cGz);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.Z(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int Z = v.Z(this.cGA);
            int Z2 = v.Z(list);
            if (Z > Z2) {
                for (int i = 0; i < Z - Z2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.c(this.cGA, i);
                    if (aVar != null) {
                        this.cGz.removeView(aVar.getView());
                    }
                    this.cGA.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < Z2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.c(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.c(this.cGA, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View nG = nG();
                    if (nG != null) {
                        a aVar4 = new a(nG);
                        this.cGA.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cGz.addView(nG);
                    }
                }
                if (i2 == Z2 - 1) {
                    a(this.cGA.get(Z2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cGF);
            this.mTbPageContext.registerListener(this.cGG);
            if (getTag() != null) {
                this.cGF.setTag(getTag());
                this.cGG.setTag(getTag());
            }
            iA(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cGC = aVar.getView();
            aVar.cGQ.setVisibility(8);
            aVar.cGO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cGP.setVisibility(8);
            aVar.cGN.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.cGN, (int) R.drawable.icon_pic_more);
            al.f(aVar.cGO, R.color.cp_cont_b, 1);
            al.k(aVar.cGN, R.drawable.selector_load_more_bg);
            this.cGC.setClickable(true);
            this.cGC.setOnClickListener(this.cGB);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cGB = onClickListener;
    }

    public View getLastItemView() {
        return this.cGC;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cGQ.setClickable(true);
            aVar2.cGQ.setOnClickListener(this.cGH);
            view.setClickable(true);
            view.setOnClickListener(this.cGI);
        }
    }

    private View nG() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cGN.setTag(aVar.forumAvatar);
            aVar2.cGN.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cGO.setText(aVar.forumName);
            aVar2.cGO.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cGP.setDefaultBgResource(0);
            aVar2.cGP.setDefaultResource(0);
            aVar2.cGQ.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cGQ.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.cGQ, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cGP.setVisibility(0);
                    al.c(aVar2.cGP, (int) R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cGP.setVisibility(0);
                    al.c(aVar2.cGP, (int) R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cGP.setVisibility(0);
                    al.c(aVar2.cGP, (int) R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cGP.setVisibility(8);
                    break;
            }
            a(view, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(R.id.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.er(z);
        }
    }

    public void iA(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cGA.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cGC != null) {
                BarImageView barImageView = (BarImageView) this.cGC.findViewById(R.id.forum_avatar);
                al.k(barImageView, R.drawable.selector_load_more_bg);
                al.c(barImageView, (int) R.drawable.icon_pic_more);
                al.f((TextView) this.cGC.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int Z = com.baidu.tbadk.core.util.v.Z(this.cGA);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < Z) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.c(this.cGA, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.cGP, (int) R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.cGP, (int) R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.cGP, (int) R.drawable.icon_grade_shaitu3);
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
            if (aVar.cGQ.getTag(R.id.forum_follow) != null && (aVar.cGQ.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.cGQ, ((Boolean) aVar.cGQ.getTag(R.id.forum_follow)).booleanValue());
            }
            al.f(aVar.cGO, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cGA.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cGO.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cGQ;
                if (((Long) next.cGO.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cGN;
        public TextView cGO;
        public TbImageView cGP;
        public EntelechyUserLikeButton cGQ;

        public a(View view) {
            super(view);
            this.cGN = null;
            this.cGO = null;
            this.cGP = null;
            this.cGQ = null;
            this.cGN = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.cGN.setGifIconSupport(false);
            this.cGO = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.cGP = (TbImageView) view.findViewById(R.id.hot_rank);
            this.cGQ = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
