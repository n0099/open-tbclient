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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
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
/* loaded from: classes.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout aSe;
    private final ArrayList<a> aSf;
    private View.OnClickListener aSg;
    private View aSh;
    private String aSi;
    private String aSj;
    private CustomMessageListener aSk;
    private CustomMessageListener aSl;
    private View.OnClickListener aSm;
    private View.OnClickListener aSn;
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
            if (this.aSl != null) {
                this.aSl.setTag(this.mTag);
            }
            if (this.aSk != null) {
                this.aSk.setTag(this.mTag);
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
        this.aSi = str;
        this.aSj = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.aSf = new ArrayList<>();
        this.mSkinType = 3;
        this.aSg = null;
        this.mTag = null;
        this.aSk = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.aSl = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.aSm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view2.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2;
                    if (an.aQ(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSi)) {
                            TiebaStatic.log(new al(HorizonalScrollListView.this.aSi).r("obj_type", 1).ac(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tt(likeModel.getErrorCode())) {
                                    AntiHelper.am(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cb(str, valueOf);
                    }
                }
            }
        };
        this.aSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = (String) view2.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                if (an.aQ(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSj)) {
                        TiebaStatic.log(new al(HorizonalScrollListView.this.aSj).ac(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aM(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSf = new ArrayList<>();
        this.mSkinType = 3;
        this.aSg = null;
        this.mTag = null;
        this.aSk = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.aSl = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.aSm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view2.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2;
                    if (an.aQ(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSi)) {
                            TiebaStatic.log(new al(HorizonalScrollListView.this.aSi).r("obj_type", 1).ac(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tt(likeModel.getErrorCode())) {
                                    AntiHelper.am(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cb(str, valueOf);
                    }
                }
            }
        };
        this.aSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = (String) view2.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                if (an.aQ(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSj)) {
                        TiebaStatic.log(new al(HorizonalScrollListView.this.aSj).ac(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aM(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSf = new ArrayList<>();
        this.mSkinType = 3;
        this.aSg = null;
        this.mTag = null;
        this.aSk = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.aSl = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.b(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.aSm = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view2.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view2;
                    if (an.aQ(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSi)) {
                            TiebaStatic.log(new al(HorizonalScrollListView.this.aSi).r("obj_type", 1).ac(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.tt(likeModel.getErrorCode())) {
                                    AntiHelper.am(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.cb(str, valueOf);
                    }
                }
            }
        };
        this.aSn = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str = (String) view2.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view2.getTag(d.g.tag_forum_id));
                if (an.aQ(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.aSj)) {
                        TiebaStatic.log(new al(HorizonalScrollListView.this.aSj).ac(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aM(context);
    }

    private void aM(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.aSe = new LinearLayout(context);
        this.aSe.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.aSe.setOrientation(0);
        addView(this.aSe);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.v(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int v = v.v(this.aSf);
            int v2 = v.v(list);
            if (v > v2) {
                for (int i = 0; i < v - v2; i++) {
                    q.a aVar = (q.a) v.c(this.aSf, i);
                    if (aVar != null) {
                        this.aSe.removeView(aVar.getView());
                    }
                    this.aSf.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < v2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.c(list, i2);
                a aVar3 = (a) v.c(this.aSf, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View kA = kA();
                    if (kA != null) {
                        a aVar4 = new a(kA);
                        this.aSf.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.aSe.addView(kA);
                    }
                }
                if (i2 == v2 - 1) {
                    a(this.aSf.get(v2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.aSk);
            this.mTbPageContext.registerListener(this.aSl);
            if (getTag() != null) {
                this.aSk.setTag(getTag());
                this.aSl.setTag(getTag());
            }
            dh(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.aSh = aVar.getView();
            aVar.aSv.setVisibility(8);
            aVar.aSt.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.recommend_frs_hot_thread_more));
            aVar.aSu.setVisibility(8);
            aVar.aSs.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ak.c(aVar.aSs, d.f.icon_pic_more);
            ak.c(aVar.aSt, d.C0126d.cp_cont_b, 1);
            ak.i(aVar.aSs, d.f.selector_load_more_bg);
            this.aSh.setClickable(true);
            this.aSh.setOnClickListener(this.aSg);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.aSg = onClickListener;
    }

    public View getLastItemView() {
        return this.aSh;
    }

    private void a(View view2, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view2 != null && view2.getTag() != null && aVar != null) {
            a aVar2 = (a) view2.getTag();
            aVar2.aSv.setClickable(true);
            aVar2.aSv.setOnClickListener(this.aSm);
            view2.setClickable(true);
            view2.setOnClickListener(this.aSn);
        }
    }

    private View kA() {
        return View.inflate(this.mTbPageContext.getPageActivity(), d.i.widget_hot_forum_list_item, null);
    }

    private void b(View view2, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view2 != null && view2.getTag() != null) {
            a aVar2 = (a) view2.getTag();
            aVar2.aSs.setTag(aVar.forumAvatar);
            aVar2.aSs.startLoad(aVar.forumAvatar, 10, false);
            aVar2.aSt.setText(aVar.forumName);
            aVar2.aSt.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.aSu.setDefaultBgResource(0);
            aVar2.aSu.setDefaultResource(0);
            aVar2.aSv.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.aSv.setTag(d.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(d.g.tag_forum_name, aVar.forumName);
            a(aVar2.aSv, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.aSu.setVisibility(0);
                    ak.c(aVar2.aSu, d.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.aSu.setVisibility(0);
                    ak.c(aVar2.aSu, d.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.aSu.setVisibility(0);
                    ak.c(aVar2.aSu, d.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.aSu.setVisibility(8);
                    break;
            }
            a(view2, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void a(EntelechyUserLikeButton entelechyUserLikeButton, boolean z) {
        if (entelechyUserLikeButton != null) {
            entelechyUserLikeButton.setTag(d.g.forum_follow, Boolean.valueOf(z));
            entelechyUserLikeButton.aQ(z);
        }
    }

    public void dh(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.aSf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.aSh != null) {
                BarImageView barImageView = (BarImageView) this.aSh.findViewById(d.g.forum_avatar);
                ak.i(barImageView, d.f.selector_load_more_bg);
                ak.c(barImageView, d.f.icon_pic_more);
                ak.c((TextView) this.aSh.findViewById(d.g.m_forum_name_textview), d.C0126d.cp_cont_b, 1);
            }
            int v = v.v(this.aSf);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < v) {
                    a aVar = (a) v.c(this.aSf, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                ak.c(aVar.aSu, d.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ak.c(aVar.aSu, d.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ak.c(aVar.aSu, d.f.icon_grade_shaitu3);
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
            if (aVar.aSv.getTag(d.g.forum_follow) != null && (aVar.aSv.getTag(d.g.forum_follow) instanceof Boolean)) {
                a(aVar.aSv, ((Boolean) aVar.aSv.getTag(d.g.forum_follow)).booleanValue());
            }
            ak.c(aVar.aSt, d.C0126d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        Iterator<a> it = this.aSf.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.aSt.getTag(d.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.aSv;
                if (((Long) next.aSt.getTag(d.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends q.a {
        public BarImageView aSs;
        public TextView aSt;
        public TbImageView aSu;
        public EntelechyUserLikeButton aSv;

        public a(View view2) {
            super(view2);
            this.aSs = null;
            this.aSt = null;
            this.aSu = null;
            this.aSv = null;
            this.aSs = (BarImageView) view2.findViewById(d.g.forum_avatar);
            this.aSs.setGifIconSupport(false);
            this.aSt = (TextView) view2.findViewById(d.g.m_forum_name_textview);
            this.aSu = (TbImageView) view2.findViewById(d.g.hot_rank);
            this.aSv = (EntelechyUserLikeButton) view2.findViewById(d.g.forum_add_love);
        }
    }
}
