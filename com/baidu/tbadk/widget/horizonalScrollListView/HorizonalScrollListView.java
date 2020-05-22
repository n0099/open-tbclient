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
import com.baidu.adp.widget.ListView.aa;
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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout ezO;
    private final ArrayList<a> ezP;
    private View.OnClickListener ezQ;
    private View ezR;
    private String ezS;
    private String ezT;
    private CustomMessageListener ezU;
    private CustomMessageListener ezV;
    private View.OnClickListener ezW;
    private View.OnClickListener ezX;
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
            if (this.ezV != null) {
                this.ezV.setTag(this.mTag);
            }
            if (this.ezU != null) {
                this.ezU.setTag(this.mTag);
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
        this.ezS = str;
        this.ezT = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.ezP = new ArrayList<>();
        this.mSkinType = 3;
        this.ezQ = null;
        this.mTag = null;
        this.ezU = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ezV = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ezW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezS)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.ezS).ag("obj_type", 1).dh("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bv(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fq(str, valueOf);
                    }
                }
            }
        };
        this.ezX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezT)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.ezT).dh("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezP = new ArrayList<>();
        this.mSkinType = 3;
        this.ezQ = null;
        this.mTag = null;
        this.ezU = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ezV = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ezW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezS)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.ezS).ag("obj_type", 1).dh("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bv(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fq(str, valueOf);
                    }
                }
            }
        };
        this.ezX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezT)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.ezT).dh("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ezP = new ArrayList<>();
        this.mSkinType = 3;
        this.ezQ = null;
        this.mTag = null;
        this.ezU = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ezV = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ezW = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezS)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.ezS).ag("obj_type", 1).dh("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bv(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aX(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fq(str, valueOf);
                    }
                }
            }
        };
        this.ezX = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ezT)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.ezT).dh("fid", valueOf));
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
        this.ezO = new LinearLayout(context);
        this.ezO.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.ezO.setOrientation(0);
        addView(this.ezO);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (v.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = v.getCount(this.ezP);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    aa.a aVar = (aa.a) v.getItem(this.ezP, i);
                    if (aVar != null) {
                        this.ezO.removeView(aVar.getView());
                    }
                    this.ezP.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) v.getItem(list, i2);
                a aVar3 = (a) v.getItem(this.ezP, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.ezP.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.ezO.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.ezP.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.ezU);
            this.mTbPageContext.registerListener(this.ezV);
            if (getTag() != null) {
                this.ezU.setTag(getTag());
                this.ezV.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.ezR = aVar.getView();
            aVar.eAf.setVisibility(8);
            aVar.eAd.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eAe.setVisibility(8);
            aVar.eAc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.eAc, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.eAd, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.eAc, R.drawable.selector_load_more_bg);
            this.ezR.setClickable(true);
            this.ezR.setOnClickListener(this.ezQ);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.ezQ = onClickListener;
    }

    public View getLastItemView() {
        return this.ezR;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.eAf.setClickable(true);
            aVar2.eAf.setOnClickListener(this.ezW);
            view.setClickable(true);
            view.setOnClickListener(this.ezX);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.eAc.setTag(aVar.forumAvatar);
            aVar2.eAc.startLoad(aVar.forumAvatar, 10, false);
            aVar2.eAd.setText(aVar.forumName);
            aVar2.eAd.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eAe.setDefaultBgResource(0);
            aVar2.eAe.setDefaultResource(0);
            aVar2.eAf.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eAf.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.eAf, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.eAe.setVisibility(0);
                    am.setImageResource(aVar2.eAe, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.eAe.setVisibility(0);
                    am.setImageResource(aVar2.eAe, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.eAe.setVisibility(0);
                    am.setImageResource(aVar2.eAe, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.eAe.setVisibility(8);
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
            entelechyUserLikeButton.hr(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ezP.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.ezR != null) {
                BarImageView barImageView = (BarImageView) this.ezR.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.ezR.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = v.getCount(this.ezP);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) v.getItem(this.ezP, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.eAe, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.eAe, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.eAe, R.drawable.icon_grade_shaitu3);
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
            if (aVar.eAf.getTag(R.id.forum_follow) != null && (aVar.eAf.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.eAf, ((Boolean) aVar.eAf.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.eAd, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.ezP.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.eAd.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.eAf;
                if (((Long) next.eAd.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends aa.a {
        public BarImageView eAc;
        public TextView eAd;
        public TbImageView eAe;
        public EntelechyUserLikeButton eAf;

        public a(View view) {
            super(view);
            this.eAc = null;
            this.eAd = null;
            this.eAe = null;
            this.eAf = null;
            this.eAc = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.eAc.setGifIconSupport(false);
            this.eAd = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.eAe = (TbImageView) view.findViewById(R.id.hot_rank);
            this.eAf = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
