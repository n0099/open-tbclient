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
/* loaded from: classes8.dex */
public class HorizonalScrollListView extends MyHorizontalScrollView {
    private final ArrayList<a> dKK;
    private View.OnClickListener dKL;
    private View dKM;
    private String dKN;
    private String dKO;
    private CustomMessageListener dKP;
    private CustomMessageListener dKQ;
    private View.OnClickListener dKR;
    private View.OnClickListener dKS;
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
            if (this.dKQ != null) {
                this.dKQ.setTag(this.mTag);
            }
            if (this.dKP != null) {
                this.dKP.setTag(this.mTag);
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
        this.dKN = str;
        this.dKO = str2;
    }

    public HorizonalScrollListView(Context context) {
        super(context);
        this.dKK = new ArrayList<>();
        this.mSkinType = 3;
        this.dKL = null;
        this.mTag = null;
        this.dKP = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dKQ = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dKR = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKN)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dKN).X("obj_type", 1).cy("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bb(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eC(str, valueOf);
                    }
                }
            }
        };
        this.dKS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKO)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dKO).cy("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dKK = new ArrayList<>();
        this.mSkinType = 3;
        this.dKL = null;
        this.mTag = null;
        this.dKP = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dKQ = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dKR = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKN)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dKN).X("obj_type", 1).cy("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bb(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eC(str, valueOf);
                    }
                }
            }
        };
        this.dKS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKO)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dKO).cy("fid", valueOf));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(HorizonalScrollListView.this.mTbPageContext.getPageActivity()).createNormalCfg(str, HorizonalScrollListView.this.getFrom())));
                }
            }
        };
        initView(context);
    }

    public HorizonalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dKK = new ArrayList<>();
        this.mSkinType = 3;
        this.dKL = null;
        this.mTag = null;
        this.dKP = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), false);
                }
            }
        };
        this.dKQ = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    HorizonalScrollListView.this.d(((Long) customResponsedMessage.getData()).longValue(), true);
                }
            }
        };
        this.dKR = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bc.checkUpIsLogin(HorizonalScrollListView.this.getContext())) {
                    String str = (String) view.getTag(R.id.tag_forum_name);
                    String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                    final EntelechyUserLikeButton entelechyUserLikeButton = (EntelechyUserLikeButton) view;
                    if (aq.isForumName(str)) {
                        if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKN)) {
                            TiebaStatic.log(new an(HorizonalScrollListView.this.dKN).X("obj_type", 1).cy("fid", valueOf));
                        }
                        final LikeModel likeModel = new LikeModel(HorizonalScrollListView.this.mTbPageContext);
                        likeModel.setLoadDataCallBack(new d() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.3.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                if ((obj instanceof t) && likeModel.getErrorCode() == 0) {
                                    t tVar = (t) obj;
                                    tVar.setLike(1);
                                    HorizonalScrollListView.this.a(entelechyUserLikeButton, tVar.isLike() == 1);
                                } else if (AntiHelper.bb(likeModel.getErrorCode(), likeModel.getErrorString())) {
                                    AntiHelper.bn(HorizonalScrollListView.this.mTbPageContext.getPageActivity(), likeModel.getErrorString());
                                } else {
                                    HorizonalScrollListView.this.mTbPageContext.showToast(likeModel.getErrorString());
                                }
                            }
                        });
                        likeModel.eC(str, valueOf);
                    }
                }
            }
        };
        this.dKS = new View.OnClickListener() { // from class: com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = (String) view.getTag(R.id.tag_forum_name);
                String valueOf = String.valueOf(view.getTag(R.id.tag_forum_id));
                if (aq.isForumName(str)) {
                    if (!TextUtils.isEmpty(HorizonalScrollListView.this.dKO)) {
                        TiebaStatic.log(new an(HorizonalScrollListView.this.dKO).cy("fid", valueOf));
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
            int count = v.getCount(this.dKK);
            int count2 = v.getCount(list);
            if (count > count2) {
                for (int i = 0; i < count - count2; i++) {
                    v.a aVar = (v.a) com.baidu.tbadk.core.util.v.getItem(this.dKK, i);
                    if (aVar != null) {
                        this.mLinearLayout.removeView(aVar.getView());
                    }
                    this.dKK.remove(aVar);
                }
            }
            for (int i2 = 0; i2 < count2; i2++) {
                com.baidu.tbadk.widget.horizonalScrollListView.a aVar2 = (com.baidu.tbadk.widget.horizonalScrollListView.a) com.baidu.tbadk.core.util.v.getItem(list, i2);
                a aVar3 = (a) com.baidu.tbadk.core.util.v.getItem(this.dKK, i2);
                if (aVar3 != null) {
                    b(aVar3.getView(), aVar2);
                } else {
                    View createView = createView();
                    if (createView != null) {
                        a aVar4 = new a(createView);
                        this.dKK.add(aVar4);
                        b(aVar4.getView(), aVar2);
                        this.mLinearLayout.addView(createView);
                    }
                }
                if (i2 == count2 - 1) {
                    a(this.dKK.get(count2 - 1));
                }
            }
            this.mTbPageContext.registerListener(this.dKP);
            this.mTbPageContext.registerListener(this.dKQ);
            if (getTag() != null) {
                this.dKP.setTag(getTag());
                this.dKQ.setTag(getTag());
            }
            onSkinTypeChanged(this.mSkinType);
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            this.dKM = aVar.getView();
            aVar.dLa.setVisibility(8);
            aVar.dKY.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dKZ.setVisibility(8);
            aVar.dKX.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            am.setImageResource(aVar.dKX, R.drawable.icon_pic_more);
            am.setViewTextColor(aVar.dKY, R.color.cp_cont_b, 1);
            am.setBackgroundResource(aVar.dKX, R.drawable.selector_load_more_bg);
            this.dKM.setClickable(true);
            this.dKM.setOnClickListener(this.dKL);
        }
    }

    public void setLoadMoreClickListener(View.OnClickListener onClickListener) {
        this.dKL = onClickListener;
    }

    public View getLastItemView() {
        return this.dKM;
    }

    private void a(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (view != null && view.getTag() != null && aVar != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dLa.setClickable(true);
            aVar2.dLa.setOnClickListener(this.dKR);
            view.setClickable(true);
            view.setOnClickListener(this.dKS);
        }
    }

    private View createView() {
        return View.inflate(this.mTbPageContext.getPageActivity(), R.layout.widget_hot_forum_list_item, null);
    }

    private void b(View view, com.baidu.tbadk.widget.horizonalScrollListView.a aVar) {
        if (aVar != null && view != null && view.getTag() != null) {
            a aVar2 = (a) view.getTag();
            aVar2.dKX.setTag(aVar.forumAvatar);
            aVar2.dKX.startLoad(aVar.forumAvatar, 10, false);
            aVar2.dKY.setText(aVar.forumName);
            aVar2.dKY.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dKZ.setDefaultBgResource(0);
            aVar2.dKZ.setDefaultResource(0);
            aVar2.dLa.setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.dLa.setTag(R.id.tag_forum_name, aVar.forumName);
            aVar2.getView().setTag(R.id.tag_forum_id, Long.valueOf(aVar.forumId));
            aVar2.getView().setTag(R.id.tag_forum_name, aVar.forumName);
            a(aVar2.dLa, aVar.isLiked);
            switch (aVar.rank) {
                case 1:
                    aVar2.dKZ.setVisibility(0);
                    am.setImageResource(aVar2.dKZ, R.drawable.icon_grade_shaitu1);
                    break;
                case 2:
                    aVar2.dKZ.setVisibility(0);
                    am.setImageResource(aVar2.dKZ, R.drawable.icon_grade_shaitu2);
                    break;
                case 3:
                    aVar2.dKZ.setVisibility(0);
                    am.setImageResource(aVar2.dKZ, R.drawable.icon_grade_shaitu3);
                    break;
                default:
                    aVar2.dKZ.setVisibility(8);
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
            entelechyUserLikeButton.fU(z);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (this.mSkinType != i) {
            Iterator<a> it = this.dKK.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    a(next, i);
                }
            }
            if (this.dKM != null) {
                BarImageView barImageView = (BarImageView) this.dKM.findViewById(R.id.forum_avatar);
                am.setBackgroundResource(barImageView, R.drawable.selector_load_more_bg);
                am.setImageResource(barImageView, R.drawable.icon_pic_more);
                am.setViewTextColor((TextView) this.dKM.findViewById(R.id.m_forum_name_textview), R.color.cp_cont_b, 1);
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.dKK);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 3 && i3 < count) {
                    a aVar = (a) com.baidu.tbadk.core.util.v.getItem(this.dKK, i3);
                    if (aVar != null) {
                        switch (i3 + 1) {
                            case 1:
                                am.setImageResource(aVar.dKZ, R.drawable.icon_grade_shaitu1);
                                continue;
                            case 2:
                                am.setImageResource(aVar.dKZ, R.drawable.icon_grade_shaitu2);
                                continue;
                            case 3:
                                am.setImageResource(aVar.dKZ, R.drawable.icon_grade_shaitu3);
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
            if (aVar.dLa.getTag(R.id.forum_follow) != null && (aVar.dLa.getTag(R.id.forum_follow) instanceof Boolean)) {
                a(aVar.dLa, ((Boolean) aVar.dLa.getTag(R.id.forum_follow)).booleanValue());
            }
            am.setViewTextColor(aVar.dKY, R.color.cp_cont_b, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(long j, boolean z) {
        Iterator<a> it = this.dKK.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getView() != null && next.dKY.getTag(R.id.tag_forum_id) != null) {
                EntelechyUserLikeButton entelechyUserLikeButton = next.dLa;
                if (((Long) next.dKY.getTag(R.id.tag_forum_id)).longValue() == j) {
                    a(entelechyUserLikeButton, z);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends v.a {
        public BarImageView dKX;
        public TextView dKY;
        public TbImageView dKZ;
        public EntelechyUserLikeButton dLa;

        public a(View view) {
            super(view);
            this.dKX = null;
            this.dKY = null;
            this.dKZ = null;
            this.dLa = null;
            this.dKX = (BarImageView) view.findViewById(R.id.forum_avatar);
            this.dKX.setGifIconSupport(false);
            this.dKY = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.dKZ = (TbImageView) view.findViewById(R.id.hot_rank);
            this.dLa = (EntelechyUserLikeButton) view.findViewById(R.id.forum_add_love);
        }
    }
}
