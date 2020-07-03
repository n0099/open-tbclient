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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout eJo;
    private final ArrayList<a> eJp;
    private View.OnClickListener eJq;
    private View eJr;
    private String eJs;
    private String eJt;
    private CustomMessageListener eJu;
    private CustomMessageListener eJv;
    private View.OnClickListener eJw;
    private View.OnClickListener eJx;
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
            if (this.eJv != null) {
                this.eJv.setTag(this.mTag);
            }
            if (this.eJu != null) {
                this.eJu.setTag(this.mTag);
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
        this.eJs = str;
        this.eJt = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.eJp = new ArrayList<>();
        this.mSkinType = 3;
        this.eJq = null;
        this.mTag = null;
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eJw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ar.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJs)) {
                            TiebaStatic.log(new ao(HorizonalScrollListView.this.eJs).ag("obj_type", 1).dk("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bA(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fx(str, valueOf);
                    }
                }
            }
        };
        this.eJx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ar.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJt)) {
                        TiebaStatic.log(new ao(HorizonalScrollListView.this.eJt).dk("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJp = new ArrayList<>();
        this.mSkinType = 3;
        this.eJq = null;
        this.mTag = null;
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eJw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ar.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJs)) {
                            TiebaStatic.log(new ao(HorizonalScrollListView.this.eJs).ag("obj_type", 1).dk("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bA(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fx(str, valueOf);
                    }
                }
            }
        };
        this.eJx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ar.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJt)) {
                        TiebaStatic.log(new ao(HorizonalScrollListView.this.eJt).dk("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJp = new ArrayList<>();
        this.mSkinType = 3;
        this.eJq = null;
        this.mTag = null;
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.eJw = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (ar.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJs)) {
                            TiebaStatic.log(new ao(HorizonalScrollListView.this.eJs).ag("obj_type", 1).dk("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bA(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fx(str, valueOf);
                    }
                }
            }
        };
        this.eJx = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (ar.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.eJt)) {
                        TiebaStatic.log(new ao(HorizonalScrollListView.this.eJt).dk("fid", valueOf));
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
        this.eJo = new LinearLayout(context);
        this.eJo.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.eJo.setOrientation(0);
        addView(this.eJo);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (w.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = w.getCount(this.eJp);
            int count2 = w.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    ad.a aVar = (ad.a) w.getItem(this.eJp, i);
                    if (aVar != null) {
                        this.eJo.removeView(aVar.getView());
                    }
                    this.eJp.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) w.getItem(list, i2);
                a aVar3 = (a) w.getItem(this.eJp, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.eJp.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.eJo.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.eJp.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.eJu);
            this.mTbPageContext.registerListener(this.eJv);
            if (getTag() != null) {
                this.eJu.setTag(getTag());
                this.eJv.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.eJr = aVar.getView();
            aVar.eJF.setVisibility(8);
            aVar.eJD.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eJE.setVisibility(8);
            aVar.eJC.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            an.setImageResource(aVar.eJC, R.drawable.icon_pic_more);
            an.setViewTextColor(aVar.eJD, R.color.cp_cont_b, 1);
            an.setBackgroundResource(aVar.eJC, R.drawable.selector_load_more_bg);
            this.eJr.setClickable(true);
            this.eJr.setOnClickListener(this.eJq);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.eJq = onClickListener;
    }

    public View getLastItemView() {
        return this.eJr;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.eJF.setClickable(true);
            aVar2.eJF.setOnClickListener(this.eJw);
            view.setClickable(true);
            view.setOnClickListener(this.eJx);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.eJC.setTag(aVar.forumAvatar);
            aVar2.eJC.startLoad(aVar.forumAvatar, 10, false);
            aVar2.eJD.setText(aVar.forumName);
            aVar2.eJD.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eJE.setDefaultBgResource(0);
            aVar2.eJE.setDefaultResource(0);
            aVar2.eJF.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eJF.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.eJF, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.eJE.setVisibility(0);
                    an.setImageResource(aVar2.eJE, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.eJE.setVisibility(0);
                    an.setImageResource(aVar2.eJE, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.eJE.setVisibility(0);
                    an.setImageResource(aVar2.eJE, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.eJE.setVisibility(8);
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
            entelechyUserLikeButton.hA(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.eJp.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.eJr != null) {
                BarImageView barImageView = (BarImageView) this.eJr.findViewById(R.id.forum_avatar);
                an.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                an.setImageResource(barImageView, R.drawable.icon_pic_more);
                an.setViewTextColor((TextView) this.eJr.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = w.getCount(this.eJp);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) w.getItem(this.eJp, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                an.setImageResource(aVar.eJE, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                an.setImageResource(aVar.eJE, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                an.setImageResource(aVar.eJE, R.drawable.icon_grade_shaitu3);
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
            if (aVar.eJF.getTag(R.id.forum_follow) != null && (aVar.eJF.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.eJF, ((Boolean) aVar.eJF.getTag(R.id.forum_follow)).booleanValue());
            }
            an.setViewTextColor(aVar.eJD, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.eJp.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.eJD.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.eJF;
                if (((Long) next.eJD.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends ad.a {
        public BarImageView eJC;
        public TextView eJD;
        public TbImageView eJE;
        public EntelechyUserLikeButton eJF;

        public a(View view) {
            super(view);
            this.eJC = null;
            this.eJD = null;
            this.eJE = null;
            this.eJF = null;
            this.eJC = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.eJC.setGifIconSupport(false);
            this.eJD = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.eJE = (TbImageView) view.findViewById(R.id.hot_rank);
            this.eJF = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
