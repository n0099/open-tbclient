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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes15.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private LinearLayout ePK;
    private final ArrayList<a> ePL;
    private View.OnClickListener ePM;
    private View ePN;
    private String ePO;
    private String ePP;
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private View.OnClickListener ePS;
    private View.OnClickListener ePT;
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
            if (this.ePR != null) {
                this.ePR.setTag(this.mTag);
            }
            if (this.ePQ != null) {
                this.ePQ.setTag(this.mTag);
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
        this.ePO = str;
        this.ePP = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (as.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePO)) {
                            TiebaStatic.log(new ap(HorizonalScrollListView.this.ePO).ah("obj_type", 1).dn("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aW(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fz(str, valueOf);
                    }
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (as.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePP)) {
                        TiebaStatic.log(new ap(HorizonalScrollListView.this.ePP).dn("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (as.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePO)) {
                            TiebaStatic.log(new ap(HorizonalScrollListView.this.ePO).ah("obj_type", 1).dn("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aW(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fz(str, valueOf);
                    }
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (as.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePP)) {
                        TiebaStatic.log(new ap(HorizonalScrollListView.this.ePP).dn("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ePL = new ArrayList<>();
        this.mSkinType = 3;
        this.ePM = null;
        this.mTag = null;
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.e(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.ePS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (as.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePO)) {
                            TiebaStatic.log(new ap(HorizonalScrollListView.this.ePO).ah("obj_type", 1).dn("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof u) && likeModel.getErrorCode() == 0) {
                                    u uVar = (u) obj;
                                    uVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, uVar.isLike() == 1);
                                } else if (AntiHelper.bB(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.aW(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.fz(str, valueOf);
                    }
                }
            }
        };
        this.ePT = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (as.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.ePP)) {
                        TiebaStatic.log(new ap(HorizonalScrollListView.this.ePP).dn("fid", valueOf));
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
        this.ePK = new LinearLayout(context);
        this.ePK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.ePK.setOrientation(0);
        addView(this.ePK);
    }

    public void setData(List<com.baidu.tbadk.widget.horizonalScrollListView.a> list, TbPageContext<?> tbPageContext) {
        if (x.getCount(list) > 0 && tbPageContext != null) {
            this.mTbPageContext = tbPageContext;
            list.add(new com.baidu.tbadk.widget.horizonalScrollListView.a());
            int count = x.getCount(this.ePL);
            int count2 = x.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    ad.a aVar = (ad.a) x.getItem(this.ePL, i);
                    if (aVar != null) {
                        this.ePK.removeView(aVar.getView());
                    }
                    this.ePL.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) x.getItem(list, i2);
                a aVar3 = (a) x.getItem(this.ePL, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.ePL.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.ePK.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.ePL.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.ePQ);
            this.mTbPageContext.registerListener(this.ePR);
            if (getTag() != null) {
                this.ePQ.setTag(getTag());
                this.ePR.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.ePN = aVar.getView();
            aVar.eQb.setVisibility(8);
            aVar.ePZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eQa.setVisibility(8);
            aVar.ePY.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ao.setImageResource(aVar.ePY, R.drawable.icon_pic_more);
            ao.setViewTextColor(aVar.ePZ, R.color.cp_cont_b, 1);
            ao.setBackgroundResource(aVar.ePY, R.drawable.selector_load_more_bg);
            this.ePN.setClickable(true);
            this.ePN.setOnClickListener(this.ePM);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.ePM = onClickListener;
    }

    public View getLastItemView() {
        return this.ePN;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.eQb.setClickable(true);
            aVar2.eQb.setOnClickListener(this.ePS);
            view.setClickable(true);
            view.setOnClickListener(this.ePT);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.ePY.setTag(aVar.forumAvatar);
            aVar2.ePY.startLoad(aVar.forumAvatar, 10, false);
            aVar2.ePZ.setText(aVar.forumName);
            aVar2.ePZ.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eQa.setDefaultBgResource(0);
            aVar2.eQa.setDefaultResource(0);
            aVar2.eQb.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.eQb.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.eQb, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.eQa.setVisibility(0);
                    ao.setImageResource(aVar2.eQa, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.eQa.setVisibility(0);
                    ao.setImageResource(aVar2.eQa, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.eQa.setVisibility(0);
                    ao.setImageResource(aVar2.eQa, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.eQa.setVisibility(8);
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
            entelechyUserLikeButton.aM(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.ePL.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.ePN != null) {
                BarImageView barImageView = (BarImageView) this.ePN.findViewById(R.id.forum_avatar);
                ao.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                ao.setImageResource(barImageView, R.drawable.icon_pic_more);
                ao.setViewTextColor((TextView) this.ePN.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = x.getCount(this.ePL);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) x.getItem(this.ePL, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                ao.setImageResource(aVar.eQa, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                ao.setImageResource(aVar.eQa, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                ao.setImageResource(aVar.eQa, R.drawable.icon_grade_shaitu3);
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
            if (aVar.eQb.getTag(R.id.forum_follow) != null && (aVar.eQb.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.eQb, ((Boolean) aVar.eQb.getTag(R.id.forum_follow)).booleanValue());
            }
            ao.setViewTextColor(aVar.ePZ, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j, boolean z) {
        Iterator<a> it = this.ePL.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.ePZ.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.eQb;
                if (((Long) next.ePZ.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class a extends ad.a {
        public BarImageView ePY;
        public TextView ePZ;
        public TbImageView eQa;
        public EntelechyUserLikeButton eQb;

        public a(View view) {
            super(view);
            this.ePY = null;
            this.ePZ = null;
            this.eQa = null;
            this.eQb = null;
            this.ePY = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.ePY.setGifIconSupport(false);
            this.ePZ = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.eQa = (TbImageView) view.findViewById(R.id.hot_rank);
            this.eQb = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
