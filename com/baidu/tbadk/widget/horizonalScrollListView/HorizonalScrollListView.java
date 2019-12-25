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
/* loaded from: classes5.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private String dGA;
    private CustomMessageListener dGB;
    private CustomMessageListener dGC;
    private View.OnClickListener dGD;
    private View.OnClickListener dGE;
    private final ArrayList<a> dGw;
    private View.OnClickListener dGx;
    private View dGy;
    private String dGz;
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
            if (this.dGC != null) {
                this.dGC.setTag(this.mTag);
            }
            if (this.dGB != null) {
                this.dGB.setTag(this.mTag);
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
        this.dGz = str;
        this.dGA = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.dGw = new ArrayList<>();
        this.mSkinType = 3;
        this.dGx = null;
        this.mTag = null;
        this.dGB = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGC = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGz)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGz).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aW(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.er(str, valueOf);
                    }
                }
            }
        };
        this.dGE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGA)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGA).cp("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dGw = new ArrayList<>();
        this.mSkinType = 3;
        this.dGx = null;
        this.mTag = null;
        this.dGB = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGC = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGz)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGz).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aW(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.er(str, valueOf);
                    }
                }
            }
        };
        this.dGE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGA)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGA).cp("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dGw = new ArrayList<>();
        this.mSkinType = 3;
        this.dGx = null;
        this.mTag = null;
        this.dGB = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dGC = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dGD = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGz)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dGz).Z("obj_type", 1).cp("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.aW(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bj(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.er(str, valueOf);
                    }
                }
            }
        };
        this.dGE = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dGA)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dGA).cp("fid", valueOf));
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
            int count = v.getCount(this.dGw);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.getItem(this.dGw, i);
                    if (aVar != null) {
                        this.mLinearLayout.removeView(aVar.getView());
                    }
                    this.dGw.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.getItem(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.getItem(this.dGw, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.dGw.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.mLinearLayout.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.dGw.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.dGB);
            this.mTbPageContext.registerListener(this.dGC);
            if (getTag() != null) {
                this.dGB.setTag(getTag());
                this.dGC.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.dGy = aVar.getView();
            aVar.dGM.setVisibility(8);
            aVar.dGK.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dGL.setVisibility(8);
            aVar.dGJ.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.dGJ, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.dGK, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.dGJ, R.drawable.selector_load_more_bg);
            this.dGy.setClickable(true);
            this.dGy.setOnClickListener(this.dGx);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.dGx = onClickListener;
    }

    public View getLastItemView() {
        return this.dGy;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dGM.setClickable(true);
            aVar2.dGM.setOnClickListener(this.dGD);
            view.setClickable(true);
            view.setOnClickListener(this.dGE);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dGJ.setTag(aVar.forumAvatar);
            aVar2.dGJ.startLoad(aVar.forumAvatar, 10, false);
            aVar2.dGK.setText(aVar.forumName);
            aVar2.dGK.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dGL.setDefaultBgResource(0);
            aVar2.dGL.setDefaultResource(0);
            aVar2.dGM.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dGM.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.dGM, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.dGL.setVisibility(0);
                    am.setImageResource(aVar2.dGL, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.dGL.setVisibility(0);
                    am.setImageResource(aVar2.dGL, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.dGL.setVisibility(0);
                    am.setImageResource(aVar2.dGL, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.dGL.setVisibility(8);
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
            entelechyUserLikeButton.fI(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.dGw.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.dGy != null) {
                BarImageView barImageView = (BarImageView) this.dGy.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.dGy.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.dGw);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.getItem(this.dGw, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.dGL, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.dGL, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.dGL, R.drawable.icon_grade_shaitu3);
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
            if (aVar.dGM.getTag(R.id.forum_follow) != null && (aVar.dGM.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.dGM, ((Boolean) aVar.dGM.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.dGK, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.dGw.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.dGK.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.dGM;
                if (((Long) next.dGK.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends v.a {
        public BarImageView dGJ;
        public TextView dGK;
        public TbImageView dGL;
        public EntelechyUserLikeButton dGM;

        public a(View view) {
            super(view);
            this.dGJ = null;
            this.dGK = null;
            this.dGL = null;
            this.dGM = null;
            this.dGJ = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.dGJ.setGifIconSupport(false);
            this.dGK = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.dGL = (TbImageView) view.findViewById(R.id.hot_rank);
            this.dGM = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
