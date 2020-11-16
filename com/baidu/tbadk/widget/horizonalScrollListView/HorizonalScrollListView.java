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
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private View.OnClickListener fDA;
    private View.OnClickListener fDB;
    private LinearLayout fDs;
    private final ArrayList<a> fDt;
    private View.OnClickListener fDu;
    private View fDv;
    private String fDw;
    private String fDx;
    private CustomMessageListener fDy;
    private CustomMessageListener fDz;
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
            if (this.fDz != null) {
                this.fDz.setTag(this.mTag);
            }
            if (this.fDy != null) {
                this.fDy.setTag(this.mTag);
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
        this.fDw = str;
        this.fDx = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.fDt = new ArrayList<>();
        this.mSkinType = 3;
        this.fDu = null;
        this.mTag = null;
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDA = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDw)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fDw).ak("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gp(str, valueOf);
                    }
                }
            }
        };
        this.fDB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDx)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fDx).dR("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDt = new ArrayList<>();
        this.mSkinType = 3;
        this.fDu = null;
        this.mTag = null;
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDA = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDw)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fDw).ak("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gp(str, valueOf);
                    }
                }
            }
        };
        this.fDB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDx)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fDx).dR("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDt = new ArrayList<>();
        this.mSkinType = 3;
        this.fDu = null;
        this.mTag = null;
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.g(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fDA = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (au.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDw)) {
                            TiebaStatic.log(new ar(HorizonalScrollListView.this.fDw).ak("obj_type", 1).dR("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bP(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gp(str, valueOf);
                    }
                }
            }
        };
        this.fDB = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (au.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fDx)) {
                        TiebaStatic.log(new ar(HorizonalScrollListView.this.fDx).dR("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dQ(context);
    }

    private void dQ(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fDs = new LinearLayout(context);
        this.fDs.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fDs.setOrientation(0);
        addView(this.fDs);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = y.getCount(this.fDt);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    af.a aVar = (af.a) y.getItem(this.fDt, i);
                    if (aVar != null) {
                        this.fDs.removeView(aVar.getView());
                    }
                    this.fDt.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                a aVar3 = (a) y.getItem(this.fDt, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.fDt.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.fDs.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.fDt.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fDy);
            this.mTbPageContext.registerListener(this.fDz);
            if (getTag() != null) {
                this.fDy.setTag(getTag());
                this.fDz.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.fDv = aVar.getView();
            aVar.fDJ.setVisibility(8);
            aVar.fDH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.fDI.setVisibility(8);
            aVar.fDG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(aVar.fDG, R.drawable.icon_pic_more);
            ap.setViewTextColor(aVar.fDH, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(aVar.fDG, R.drawable.selector_load_more_bg);
            this.fDv.setClickable(true);
            this.fDv.setOnClickListener(this.fDu);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fDu = onClickListener;
    }

    public View getLastItemView() {
        return this.fDv;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fDJ.setClickable(true);
            aVar2.fDJ.setOnClickListener(this.fDA);
            view.setClickable(true);
            view.setOnClickListener(this.fDB);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fDG.setTag(aVar.forumAvatar);
            aVar2.fDG.startLoad(aVar.forumAvatar, 10, false);
            aVar2.fDH.setText(aVar.forumName);
            aVar2.fDH.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.fDI.setDefaultBgResource(0);
            aVar2.fDI.setDefaultResource(0);
            aVar2.fDJ.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.fDJ.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.fDJ, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.fDI.setVisibility(0);
                    ap.setImageResource(aVar2.fDI, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.fDI.setVisibility(0);
                    ap.setImageResource(aVar2.fDI, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.fDI.setVisibility(0);
                    ap.setImageResource(aVar2.fDI, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.fDI.setVisibility(8);
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
            entelechyUserLikeButton.aP(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.fDt.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fDv != null) {
                BarImageView barImageView = (BarImageView) this.fDv.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fDv.findViewById(R.id.m_forum_name_textview), R.color.CAM_X0105, 1);
            }
            int count = y.getCount(this.fDt);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) y.getItem(this.fDt, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                ap.setImageResource(aVar.fDI, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ap.setImageResource(aVar.fDI, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ap.setImageResource(aVar.fDI, R.drawable.icon_grade_shaitu3);
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
            if (aVar.fDJ.getTag(R.id.forum_follow) != null && (aVar.fDJ.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.fDJ, ((Boolean) aVar.fDJ.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(aVar.fDH, R.color.CAM_X0105, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j, boolean z) {
        Iterator<a> it = this.fDt.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.fDH.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.fDJ;
                if (((Long) next.fDH.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class a extends af.a {
        public BarImageView fDG;
        public TextView fDH;
        public TbImageView fDI;
        public EntelechyUserLikeButton fDJ;

        public a(View view) {
            super(view);
            this.fDG = null;
            this.fDH = null;
            this.fDI = null;
            this.fDJ = null;
            this.fDG = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fDG.setGifIconSupport(false);
            this.fDH = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.fDI = (TbImageView) view.findViewById(R.id.hot_rank);
            this.fDJ = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
