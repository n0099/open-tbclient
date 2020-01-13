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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private final ArrayList<a> dGF;
    private View.OnClickListener dGG;
    private View dGH;
    private String dGI;
    private String dGJ;
    private CustomMessageListener dGK;
    private CustomMessageListener dGL;
    private View.OnClickListener dGM;
    private View.OnClickListener dGN;
    private String mFrom;
    private LinearLayout mLinearLayout;
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
            if (this.dGL != null) {
                this.dGL.setTag(this.mTag);
            }
            if (this.dGK != null) {
                this.dGK.setTag(this.mTag);
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
        this.dGI = str;
        this.dGJ = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.dGF = new ArrayList<>();
        this.mSkinType = 3;
        this.dGG = null;
        this.mTag = null;
        this.dGK = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGL = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGI)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGI).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bc(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.et(str, valueOf);
                    }
                }
            }
        };
        this.dGN = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGJ)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGJ).cp("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGF = new ArrayList<>();
        this.mSkinType = 3;
        this.dGG = null;
        this.mTag = null;
        this.dGK = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGL = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGI)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGI).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bc(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.et(str, valueOf);
                    }
                }
            }
        };
        this.dGN = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGJ)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGJ).cp("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGF = new ArrayList<>();
        this.mSkinType = 3;
        this.dGG = null;
        this.mTag = null;
        this.dGK = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGL = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGM = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGI)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGI).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bc(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.et(str, valueOf);
                    }
                }
            }
        };
        this.dGN = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGJ)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGJ).cp("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
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
        this.mLinearLayout = new LinearLayout(context);
        this.mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.mLinearLayout.setOrientation(0);
        addView(this.mLinearLayout);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = v.getCount(this.dGF);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.getItem(this.dGF, i);
                    if (aVar != null) {
                        this.mLinearLayout.removeView(aVar.getView());
                    }
                    this.dGF.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.getItem(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.getItem(this.dGF, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.dGF.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.mLinearLayout.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.dGF.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.dGK);
            this.mTbPageContext.registerListener(this.dGL);
            if (getTag() != null) {
                this.dGK.setTag(getTag());
                this.dGL.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.dGH = aVar.getView();
            aVar.dGV.setVisibility(8);
            aVar.dGT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dGU.setVisibility(8);
            aVar.dGS.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.dGS, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.dGT, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.dGS, R.drawable.selector_load_more_bg);
            this.dGH.setClickable(true);
            this.dGH.setOnClickListener(this.dGG);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.dGG = onClickListener;
    }

    public View getLastItemView() {
        return this.dGH;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dGV.setClickable(true);
            aVar2.dGV.setOnClickListener(this.dGM);
            view.setClickable(true);
            view.setOnClickListener(this.dGN);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dGS.setTag(aVar.forumAvatar);
            aVar2.dGS.startLoad(aVar.forumAvatar, 10, false);
            aVar2.dGT.setText(aVar.forumName);
            aVar2.dGT.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dGU.setDefaultBgResource(0);
            aVar2.dGU.setDefaultResource(0);
            aVar2.dGV.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dGV.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.dGV, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.dGU.setVisibility(0);
                    am.setImageResource(aVar2.dGU, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.dGU.setVisibility(0);
                    am.setImageResource(aVar2.dGU, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.dGU.setVisibility(0);
                    am.setImageResource(aVar2.dGU, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.dGU.setVisibility(8);
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
            entelechyUserLikeButton.fN(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.dGF.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.dGH != null) {
                BarImageView barImageView = (BarImageView) this.dGH.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.dGH.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.dGF);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.getItem(this.dGF, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.dGU, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.dGU, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.dGU, R.drawable.icon_grade_shaitu3);
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
            if (aVar.dGV.getTag(R.id.forum_follow) != null && (aVar.dGV.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.dGV, ((Boolean) aVar.dGV.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.dGT, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.dGF.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.dGT.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.dGV;
                if (((Long) next.dGT.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public BarImageView dGS;
        public TextView dGT;
        public TbImageView dGU;
        public EntelechyUserLikeButton dGV;

        public a(View view) {
            super(view);
            this.dGS = null;
            this.dGT = null;
            this.dGU = null;
            this.dGV = null;
            this.dGS = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.dGS.setGifIconSupport(false);
            this.dGT = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.dGU = (TbImageView) view.findViewById(R.id.hot_rank);
            this.dGV = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
