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
import com.baidu.tbadk.core.util.ba;
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
    private LinearLayout bbc;
    private final ArrayList<a> bbd;
    private View.OnClickListener bbe;
    private View bbf;
    private String bbg;
    private String bbh;
    private CustomMessageListener bbi;
    private CustomMessageListener bbj;
    private View.OnClickListener bbk;
    private View.OnClickListener bbl;
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
            if (this.bbj != null) {
                this.bbj.setTag(this.mTag);
            }
            if (this.bbi != null) {
                this.bbi.setTag(this.mTag);
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
        this.bbg = str;
        this.bbh = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.bbd = new ArrayList<>();
        this.mSkinType = 3;
        this.bbe = null;
        this.mTag = null;
        this.bbi = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbj = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbk = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aV(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbg)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.bbg).r("obj_type", 1).af(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aq(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ck(str, valueOf);
                    }
                }
            }
        };
        this.bbl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbh)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bbh).af(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aX(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbd = new ArrayList<>();
        this.mSkinType = 3;
        this.bbe = null;
        this.mTag = null;
        this.bbi = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbj = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbk = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aV(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbg)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.bbg).r("obj_type", 1).af(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aq(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ck(str, valueOf);
                    }
                }
            }
        };
        this.bbl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbh)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bbh).af(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aX(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbd = new ArrayList<>();
        this.mSkinType = 3;
        this.bbe = null;
        this.mTag = null;
        this.bbi = new CustomMessageListener(2001336) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.bbj = new CustomMessageListener(2001335) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.a(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.bbk = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aV(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(d.g.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ap.bf(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbg)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.bbg).r("obj_type", 1).af(ImageViewerConfig.FORUM_ID, valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                if ((obj instanceof r) && likeModel.getErrorCode() == 0) {
                                    r rVar = (r) obj;
                                    rVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, rVar.isLike() == 1);
                                } else if (AntiHelper.al(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aq(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.ck(str, valueOf);
                    }
                }
            }
        };
        this.bbl = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(d.g.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(d.g.tag_forum_id));
                if (ap.bf(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.bbh)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.bbh).af(ImageViewerConfig.FORUM_ID, valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        aX(context);
    }

    private void aX(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.bbc = new LinearLayout(context);
        this.bbc.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.bbc.setOrientation(0);
        addView(this.bbc);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (w.y(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int y = w.y(this.bbd);
            int y2 = w.y(list);
            if (y > y2) {
                for (int i = 0; i < y - y2; i++) {
                    q.a aVar = (q.a) w.d(this.bbd, i);
                    if (aVar != null) {
                        this.bbc.removeView(aVar.getView());
                    }
                    this.bbd.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < y2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) w.d(list, i2);
                a aVar3 = (a) w.d(this.bbd, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View np = np();
                    if (np != null) {
                        a aVar4 = new a(np);
                        this.bbd.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.bbc.addView(np);
                    }
                }
                if (i2 == y2 - 1) {
                    a(this.bbd.get(y2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.bbi);
            this.mTbPageContext.registerListener(this.bbj);
            if (getTag() != null) {
                this.bbi.setTag(getTag());
                this.bbj.setTag(getTag());
            }
            dn(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.bbf = aVar.getView();
            aVar.bbt.setVisibility(8);
            aVar.bbr.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.recommend_frs_hot_thread_more));
            aVar.bbs.setVisibility(8);
            aVar.bbq.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.c(aVar.bbq, d.f.icon_pic_more);
            am.c(aVar.bbr, d.C0140d.cp_cont_b, 1);
            am.i(aVar.bbq, d.f.selector_load_more_bg);
            this.bbf.setClickable(true);
            this.bbf.setOnClickListener(this.bbe);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.bbe = onClickListener;
    }

    public View getLastItemView() {
        return this.bbf;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bbt.setClickable(true);
            aVar2.bbt.setOnClickListener(this.bbk);
            view.setClickable(true);
            view.setOnClickListener(this.bbl);
        }
    }

    private View np() {
        return View.inflate(this.mTbPageContext.getPageActivity(), d.h.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.bbq.setTag(aVar.forumAvatar);
            aVar2.bbq.startLoad(aVar.forumAvatar, 10, false);
            aVar2.bbr.setText(aVar.forumName);
            aVar2.bbr.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bbs.setDefaultBgResource(0);
            aVar2.bbs.setDefaultResource(0);
            aVar2.bbt.setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.bbt.setTag(d.g.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(d.g.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(d.g.tag_forum_name, aVar.forumName);
            a(aVar2.bbt, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.bbs.setVisibility(0);
                    am.c(aVar2.bbs, d.f.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.bbs.setVisibility(0);
                    am.c(aVar2.bbs, d.f.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.bbs.setVisibility(0);
                    am.c(aVar2.bbs, d.f.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.bbs.setVisibility(8);
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
            entelechyUserLikeButton.aV(z);
        }
    }

    public void dn(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.bbd.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.bbf != null) {
                BarImageView barImageView = (BarImageView) this.bbf.findViewById(d.g.forum_avatar);
                am.i(barImageView, d.f.selector_load_more_bg);
                am.c(barImageView, d.f.icon_pic_more);
                am.c((TextView) this.bbf.findViewById(d.g.m_forum_name_textview), d.C0140d.cp_cont_b, 1);
            }
            int y = w.y(this.bbd);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < y) {
                    a aVar = (a) w.d(this.bbd, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.c(aVar.bbs, d.f.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.c(aVar.bbs, d.f.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.c(aVar.bbs, d.f.icon_grade_shaitu3);
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
            if (aVar.bbt.getTag(d.g.forum_follow) != null && (aVar.bbt.getTag(d.g.forum_follow) instanceof Boolean)) {
                a(aVar.bbt, ((Boolean) aVar.bbt.getTag(d.g.forum_follow)).booleanValue());
            }
            am.c(aVar.bbr, d.C0140d.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        Iterator<a> it = this.bbd.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.bbr.getTag(d.g.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.bbt;
                if (((Long) next.bbr.getTag(d.g.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public BarImageView bbq;
        public TextView bbr;
        public TbImageView bbs;
        public EntelechyUserLikeButton bbt;

        public a(View view) {
            super(view);
            this.bbq = null;
            this.bbr = null;
            this.bbs = null;
            this.bbt = null;
            this.bbq = (BarImageView) view.findViewById(d.g.forum_avatar);
            this.bbq.setGifIconSupport(false);
            this.bbr = (TextView) view.findViewById(d.g.m_forum_name_textview);
            this.bbs = (TbImageView) view.findViewById(d.g.hot_rank);
            this.bbt = (EntelechyUserLikeButton) view.findViewById(d.g.forum_add_love);
        }
    }
}
