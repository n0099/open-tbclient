package com.baidu.tieba.enterForum.hotuserrank;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes2.dex */
public class a {
    private View iBw;
    private TextView iEg;
    private TextView iEh;
    private TextView iEi;
    private ImageView iEj;
    private ImageView iEk;
    private ImageView iEl;
    private ImageView iEm;
    private ImageView iEn;
    private IrregularImageView iEo;
    private TextView iEp;
    private RelativeLayout iEq;
    private ImageView iEr;
    private TextView iEs;
    private ImageOverlayView iEt;
    private ImageView iEu;
    private ImageView iEv;
    private String iEw;
    private com.baidu.tieba.enterForum.hotuserrank.a.a iEx;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iBw.getId() && a.this.iEx != null && a.this.iEx.iFs != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.iEx.iFs.getUserId(), a.this.iEx.iFs.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dW("resource_id", a.this.iEx.rankName);
                    aqVar.dW("friend_uid", a.this.iEx.iFs.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dW("uid", a.this.iEx.iFs.getUserId());
                aqVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iBw = view.findViewById(R.id.top_container);
        this.iBw.setOnClickListener(this.mOnClickListener);
        this.iEg = (TextView) view.findViewById(R.id.rank_name);
        this.iEg.getPaint().setFakeBoldText(true);
        this.iEh = (TextView) view.findViewById(R.id.top_user_name);
        this.iEi = (TextView) view.findViewById(R.id.rank_data);
        this.iEj = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.iEk = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.iEl = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.iEm = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.iEn = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.iEo = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.iEo.setErrorRes(R.drawable.pic_list_avatar);
        this.iEj.setImageDrawable(SvgManager.bsx().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.iEk.setImageDrawable(SvgManager.bsx().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.iEl.setImageDrawable(SvgManager.bsx().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.iEm.setImageDrawable(SvgManager.bsx().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.iEn.setImageDrawable(SvgManager.bsx().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.iEp = (TextView) view.findViewById(R.id.text_compute_method);
        this.iEp.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.iEq = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.iEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.iEw);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.iEr = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.iEs = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.iEv = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.iEt = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.iEt.l(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.iEt.setStrokeStyle(1);
        this.iEt.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iEt.setLoadImageType(12);
        this.iEu = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.iEx = aVar;
        if (aVar != null) {
            this.iEg.setText(aVar.rankName);
            if (aVar.iFs != null) {
                String str = aVar.iFr;
                if (ad.getTextLengthWithEmoji(aVar.iFr) > 10) {
                    str = ad.subStringWithEmoji(aVar.iFr, 10) + StringHelper.STRING_MORE;
                }
                this.iEh.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.iFt == 0) {
                this.iEi.setVisibility(8);
            } else {
                this.iEi.setVisibility(0);
                this.iEi.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.dQ(aVar.iFt * 1000)));
            }
            this.iEo.setImage(aVar.iFu, gf(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.iFv != null && !z && !TextUtils.isEmpty(aVar.iFv.tieba_name)) {
                this.iEq.setVisibility(0);
                this.iEs.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.iFv.tieba_name));
                List<String> cU = cU(aVar.iFv.user_rank);
                this.iEt.setData(cU);
                cV(cU);
                this.iEw = aVar.iFv.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.w("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.iEq.setVisibility(8);
        }
    }

    private List<String> cU(List<User> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User user : list) {
            if (user != null) {
                arrayList.add(user.portrait);
            }
        }
        return arrayList;
    }

    private void cV(List<String> list) {
        int count = x.getCount(list);
        if (count == 0) {
            this.iEv.setVisibility(8);
            return;
        }
        this.iEv.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iEv.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.iEv.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iEp, R.color.CAM_X0109);
            SvgManager.bsx().a(this.iEr, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bsx().a(this.iEv, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.a(this.iEu, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            ao.setViewTextColor(this.iEs, R.color.CAM_X0105);
            this.iEt.onChangeSkinType();
        }
    }

    public BdUniqueId gf(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
