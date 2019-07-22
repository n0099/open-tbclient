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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
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
    private LinearLayout cHT;
    private final ArrayList<a> cHU;
    private View.OnClickListener cHV;
    private View cHW;
    private String cHX;
    private String cHY;
    private CustomMessageListener cHZ;
    private CustomMessageListener cIa;
    private View.OnClickListener cIb;
    private View.OnClickListener cIc;
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
            if (this.cIa != null) {
                this.cIa.setTag(this.mTag);
            }
            if (this.cHZ != null) {
                this.cHZ.setTag(this.mTag);
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
        this.cHX = str;
        this.cHY = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.cHU = new ArrayList<>();
        this.mSkinType = 3;
        this.cHV = null;
        this.mTag = null;
        this.cHZ = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cIa = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cIb = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bd.cF(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.bg(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHX)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cHX).P("obj_type", 1).bT("fid", valueOf));
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
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.el(str, valueOf);
                    }
                }
            }
        };
        this.cIc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.bg(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHY)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cHY).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHU = new ArrayList<>();
        this.mSkinType = 3;
        this.cHV = null;
        this.mTag = null;
        this.cHZ = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cIa = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cIb = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bd.cF(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.bg(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHX)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cHX).P("obj_type", 1).bT("fid", valueOf));
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
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.el(str, valueOf);
                    }
                }
            }
        };
        this.cIc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.bg(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHY)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cHY).bT("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cHU = new ArrayList<>();
        this.mSkinType = 3;
        this.cHV = null;
        this.mTag = null;
        this.cHZ = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.cIa = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.cIb = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bd.cF(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.bg(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHX)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.cHX).P("obj_type", 1).bT("fid", valueOf));
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
                                    AntiHelper.aJ(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.el(str, valueOf);
                    }
                }
            }
        };
        this.cIc = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.bg(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.cHY)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.cHY).bT("fid", valueOf));
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
        this.cHT = new LinearLayout(context);
        this.cHT.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.cHT.setOrientation(0);
        addView(this.cHT);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.Z(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int Z = v.Z(this.cHU);
            int Z2 = v.Z(list);
            if (Z > Z2) {
                for (int i = 0; i < Z - Z2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.c(this.cHU, i);
                    if (aVar != null) {
                        this.cHT.removeView(aVar.getView());
                    }
                    this.cHU.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < Z2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.c(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.c(this.cHU, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View nZ = nZ();
                    if (nZ != null) {
                        a aVar4 = new a(nZ);
                        this.cHU.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.cHT.addView(nZ);
                    }
                }
                if (i2 == Z2 - 1) {
                    a(this.cHU.get(Z2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.cHZ);
            this.mTbPageContext.registerListener(this.cIa);
            if (getTag() != null) {
                this.cHZ.setTag(getTag());
                this.cIa.setTag(getTag());
            }
            iG(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.cHW = aVar.getView();
            aVar.cIk.setVisibility(8);
            aVar.cIi.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cIj.setVisibility(8);
            aVar.cIh.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.c(aVar.cIh, (int) R.drawable.icon_pic_more);
            am.f(aVar.cIi, R.color.cp_cont_b, 1);
            am.k(aVar.cIh, R.drawable.selector_load_more_bg);
            this.cHW.setClickable(true);
            this.cHW.setOnClickListener(this.cHV);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.cHV = onClickListener;
    }

    public View getLastItemView() {
        return this.cHW;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cIk.setClickable(true);
            aVar2.cIk.setOnClickListener(this.cIb);
            view.setClickable(true);
            view.setOnClickListener(this.cIc);
        }
    }

    private View nZ() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.cIh.setTag(aVar.forumAvatar);
            aVar2.cIh.startLoad(aVar.forumAvatar, 10, false);
            aVar2.cIi.setText(aVar.forumName);
            aVar2.cIi.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cIj.setDefaultBgResource(0);
            aVar2.cIj.setDefaultResource(0);
            aVar2.cIk.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.cIk.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.cIk, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.cIj.setVisibility(0);
                    am.c(aVar2.cIj, (int) R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.cIj.setVisibility(0);
                    am.c(aVar2.cIj, (int) R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.cIj.setVisibility(0);
                    am.c(aVar2.cIj, (int) R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.cIj.setVisibility(8);
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
            entelechyUserLikeButton.ev(z);
        }
    }

    public void iG(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.cHU.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.cHW != null) {
                BarImageView barImageView = (BarImageView) this.cHW.findViewById(R.id.forum_avatar);
                am.k(barImageView, R.drawable.selector_load_more_bg);
                am.c(barImageView, (int) R.drawable.icon_pic_more);
                am.f((TextView) this.cHW.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int Z = com.baidu.tbadk.core.util.v.Z(this.cHU);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < Z) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.c(this.cHU, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.c(aVar.cIj, (int) R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.c(aVar.cIj, (int) R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.c(aVar.cIj, (int) R.drawable.icon_grade_shaitu3);
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
            if (aVar.cIk.getTag(R.id.forum_follow) != null && (aVar.cIk.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.cIk, ((Boolean) aVar.cIk.getTag(R.id.forum_follow)).booleanValue());
            }
            am.f(aVar.cIi, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.cHU.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.cIi.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.cIk;
                if (((Long) next.cIi.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public BarImageView cIh;
        public TextView cIi;
        public TbImageView cIj;
        public EntelechyUserLikeButton cIk;

        public a(View view) {
            super(view);
            this.cIh = null;
            this.cIi = null;
            this.cIj = null;
            this.cIk = null;
            this.cIh = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.cIh.setGifIconSupport(false);
            this.cIi = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.cIj = (TbImageView) view.findViewById(R.id.hot_rank);
            this.cIk = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
