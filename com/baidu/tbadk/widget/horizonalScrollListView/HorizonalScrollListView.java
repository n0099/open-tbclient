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
    private View.OnClickListener cGA;
    private View cGB;
    private String cGC;
    private String cGD;
    private CustomMessageListener cGE;
    private CustomMessageListener cGF;
    private View.OnClickListener cGG;
    private View.OnClickListener cGH;
    private LinearLayout cGy;
    private final ArrayList<a> cGz;
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
            if (this.cGF != null) {
                this.cGF.setTag(this.mTag);
            }
            if (this.cGE != null) {
                this.cGE.setTag(this.mTag);
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
        this.cGC = str;
        this.cGD = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cGz = new ArrayList<>();
        this.mSkinType = 3;
        this.cGA = null;
        this.mTag = null;
        this.cGE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGC).P("obj_type", 1).bT("fid", valueOf));
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
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGz = new ArrayList<>();
        this.mSkinType = 3;
        this.cGA = null;
        this.mTag = null;
        this.cGE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGC).P("obj_type", 1).bT("fid", valueOf));
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
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGz = new ArrayList<>();
        this.mSkinType = 3;
        this.cGA = null;
        this.mTag = null;
        this.cGE = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cGF = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cGG = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.cE(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGC)) {
                            TiebaStatic.log(new am(HorizonalScrollListView.this.cGC).P("obj_type", 1).bT("fid", valueOf));
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
        this.cGH = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cGD)) {
                        TiebaStatic.log(new am(HorizonalScrollListView.this.cGD).bT("fid", valueOf));
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
        this.cGy = new LinearLayout(context);
        this.cGy.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cGy.setOrientation(0);
        addView(this.cGy);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.Z(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int Z = v.Z(this.cGz);
            int Z2 = v.Z(list);
            if (Z > Z2) {
                for (int i = 0; i < Z - Z2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.c(this.cGz, i);
                    if (aVar != null) {
                        this.cGy.removeView(aVar.getView());
                    }
                    this.cGz.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < Z2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.c(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.c(this.cGz, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View nG = nG();
                    if (nG != null) {
                        a aVar4 = new a(nG);
                        this.cGz.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cGy.addView(nG);
                    }
                }
                if (i2 == Z2 - 1) {
                    a(this.cGz.get(Z2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cGE);
            this.mTbPageContext.registerListener(this.cGF);
            if (getTag() != null) {
                this.cGE.setTag(getTag());
                this.cGF.setTag(getTag());
            }
            iA(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cGB = aVar.getView();
            aVar.cGP.setVisibility(8);
            aVar.cGN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cGO.setVisibility(8);
            aVar.cGM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            al.c(aVar.cGM, (int) R.drawable.icon_pic_more);
            al.f(aVar.cGN, R.color.cp_cont_b, 1);
            al.k(aVar.cGM, R.drawable.selector_load_more_bg);
            this.cGB.setClickable(true);
            this.cGB.setOnClickListener(this.cGA);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cGA = onClickListener;
    }

    public View getLastItemView() {
        return this.cGB;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cGP.setClickable(true);
            aVar2.cGP.setOnClickListener(this.cGG);
            view.setClickable(true);
            view.setOnClickListener(this.cGH);
        }
    }

    private View nG() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cGM.setTag(aVar.forumAvatar);
            aVar2.cGM.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cGN.setText(aVar.forumName);
            aVar2.cGN.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cGO.setDefaultBgResource(0);
            aVar2.cGO.setDefaultResource(0);
            aVar2.cGP.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cGP.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.cGP, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cGO.setVisibility(0);
                    al.c(aVar2.cGO, (int) R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cGO.setVisibility(0);
                    al.c(aVar2.cGO, (int) R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cGO.setVisibility(0);
                    al.c(aVar2.cGO, (int) R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cGO.setVisibility(8);
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
            Iterator<a> it = this.cGz.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cGB != null) {
                BarImageView barImageView = (BarImageView) this.cGB.findViewById(R.id.forum_avatar);
                al.k(barImageView, R.drawable.selector_load_more_bg);
                al.c(barImageView, (int) R.drawable.icon_pic_more);
                al.f((TextView) this.cGB.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int Z = com.baidu.tbadk.core.util.v.Z(this.cGz);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < Z) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.c(this.cGz, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                al.c(aVar.cGO, (int) R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                al.c(aVar.cGO, (int) R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                al.c(aVar.cGO, (int) R.drawable.icon_grade_shaitu3);
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
            if (aVar.cGP.getTag(R.id.forum_follow) != null && (aVar.cGP.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.cGP, ((Boolean) aVar.cGP.getTag(R.id.forum_follow)).booleanValue());
            }
            al.f(aVar.cGN, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cGz.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cGN.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cGP;
                if (((Long) next.cGN.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cGM;
        public TextView cGN;
        public TbImageView cGO;
        public EntelechyUserLikeButton cGP;

        public a(View view) {
            super(view);
            this.cGM = null;
            this.cGN = null;
            this.cGO = null;
            this.cGP = null;
            this.cGM = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.cGM.setGifIconSupport(false);
            this.cGN = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.cGO = (TbImageView) view.findViewById(R.id.hot_rank);
            this.cGP = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
