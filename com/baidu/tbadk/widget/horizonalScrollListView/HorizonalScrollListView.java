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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
    private LinearLayout fdn;
    private final ArrayList<a> fdo;
    private View.OnClickListener fdp;
    private View fdq;
    private String fdr;
    private String fds;
    private CustomMessageListener fdt;
    private CustomMessageListener fdu;
    private View.OnClickListener fdv;
    private View.OnClickListener fdw;
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
            if (this.fdu != null) {
                this.fdu.setTag(this.mTag);
            }
            if (this.fdt != null) {
                this.fdt.setTag(this.mTag);
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
        this.fdr = str;
        this.fds = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.fdo = new ArrayList<>();
        this.mSkinType = 3;
        this.fdp = null;
        this.mTag = null;
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fdv = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fdr)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fdr).ai("obj_type", 1).dF("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bC(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bh(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gd(str, valueOf);
                    }
                }
            }
        };
        this.fdw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fds)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fds).dF("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dK(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdo = new ArrayList<>();
        this.mSkinType = 3;
        this.fdp = null;
        this.mTag = null;
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fdv = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fdr)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fdr).ai("obj_type", 1).dF("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bC(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bh(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gd(str, valueOf);
                    }
                }
            }
        };
        this.fdw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fds)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fds).dF("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dK(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdo = new ArrayList<>();
        this.mSkinType = 3;
        this.fdp = null;
        this.mTag = null;
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.f(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.fdv = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (at.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.fdr)) {
                            TiebaStatic.log(new aq(HorizonalScrollListView.this.fdr).ai("obj_type", 1).dF("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof v) && likeModel.getErrorCode() == 0) {
                                    v vVar = (v) obj;
                                    vVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, vVar.isLike() == 1);
                                } else if (AntiHelper.bC(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bh(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.gd(str, valueOf);
                    }
                }
            }
        };
        this.fdw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (at.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.fds)) {
                        TiebaStatic.log(new aq(HorizonalScrollListView.this.fds).dF("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        dK(context);
    }

    private void dK(Context context) {
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        this.fdn = new LinearLayout(context);
        this.fdn.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.fdn.setOrientation(0);
        addView(this.fdn);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (y.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = y.getCount(this.fdo);
            int count2 = y.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    af.a aVar = (af.a) y.getItem(this.fdo, i);
                    if (aVar != null) {
                        this.fdn.removeView(aVar.getView());
                    }
                    this.fdo.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) y.getItem(list, i2);
                a aVar3 = (a) y.getItem(this.fdo, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.fdo.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.fdn.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.fdo.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.fdt);
            this.mTbPageContext.registerListener(this.fdu);
            if (getTag() != null) {
                this.fdt.setTag(getTag());
                this.fdu.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.fdq = aVar.getView();
            aVar.fdE.setVisibility(8);
            aVar.fdC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.fdD.setVisibility(8);
            aVar.fdB.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ap.setImageResource(aVar.fdB, R.drawable.icon_pic_more);
            ap.setViewTextColor(aVar.fdC, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(aVar.fdB, R.drawable.selector_load_more_bg);
            this.fdq.setClickable(true);
            this.fdq.setOnClickListener(this.fdp);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.fdp = onClickListener;
    }

    public View getLastItemView() {
        return this.fdq;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fdE.setClickable(true);
            aVar2.fdE.setOnClickListener(this.fdv);
            view.setClickable(true);
            view.setOnClickListener(this.fdw);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.fdB.setTag(aVar.forumAvatar);
            aVar2.fdB.startLoad(aVar.forumAvatar, 10, false);
            aVar2.fdC.setText(aVar.forumName);
            aVar2.fdC.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.fdD.setDefaultBgResource(0);
            aVar2.fdD.setDefaultResource(0);
            aVar2.fdE.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.fdE.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.fdE, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.fdD.setVisibility(0);
                    ap.setImageResource(aVar2.fdD, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.fdD.setVisibility(0);
                    ap.setImageResource(aVar2.fdD, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.fdD.setVisibility(0);
                    ap.setImageResource(aVar2.fdD, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.fdD.setVisibility(8);
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
            entelechyUserLikeButton.aN(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.fdo.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.fdq != null) {
                BarImageView barImageView = (BarImageView) this.fdq.findViewById(R.id.forum_avatar);
                ap.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ap.setImageResource(barImageView, R.drawable.icon_pic_more);
                ap.setViewTextColor((TextView) this.fdq.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = y.getCount(this.fdo);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) y.getItem(this.fdo, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                ap.setImageResource(aVar.fdD, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ap.setImageResource(aVar.fdD, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ap.setImageResource(aVar.fdD, R.drawable.icon_grade_shaitu3);
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
            if (aVar.fdE.getTag(R.id.forum_follow) != null && (aVar.fdE.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.fdE, ((Boolean) aVar.fdE.getTag(R.id.forum_follow)).booleanValue());
            }
            ap.setViewTextColor(aVar.fdC, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(long j, boolean z) {
        Iterator<a> it = this.fdo.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.fdC.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.fdE;
                if (((Long) next.fdC.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class a extends af.a {
        public BarImageView fdB;
        public TextView fdC;
        public TbImageView fdD;
        public EntelechyUserLikeButton fdE;

        public a(View view) {
            super(view);
            this.fdB = null;
            this.fdC = null;
            this.fdD = null;
            this.fdE = null;
            this.fdB = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.fdB.setGifIconSupport(false);
            this.fdC = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.fdD = (TbImageView) view.findViewById(R.id.hot_rank);
            this.fdE = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
