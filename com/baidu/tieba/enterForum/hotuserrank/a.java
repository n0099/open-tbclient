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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes16.dex */
public class a {
    private View hgK;
    private ImageView hjA;
    private ImageView hjB;
    private ImageView hjC;
    private IrregularImageView hjD;
    private TextView hjE;
    private RelativeLayout hjF;
    private ImageView hjG;
    private TextView hjH;
    private ImageOverlayView hjI;
    private ImageView hjJ;
    private ImageView hjK;
    private String hjL;
    private com.baidu.tieba.enterForum.hotuserrank.a.a hjM;
    private TextView hjv;
    private TextView hjw;
    private TextView hjx;
    private ImageView hjy;
    private ImageView hjz;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.hgK.getId() && a.this.hjM != null && a.this.hjM.hkJ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.hjM.hkJ.getUserId(), a.this.hjM.hkJ.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    ap apVar = new ap("c13659");
                    apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    apVar.dn("resource_id", a.this.hjM.hkH);
                    apVar.dn("friend_uid", a.this.hjM.hkJ.rankNum);
                    TiebaStatic.log(apVar);
                    return;
                }
                ap apVar2 = new ap("c13683");
                apVar2.dn("uid", a.this.hjM.hkJ.getUserId());
                apVar2.t("fid", a.this.mForumId);
                TiebaStatic.log(apVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.hgK = view.findViewById(R.id.top_container);
        this.hgK.setOnClickListener(this.mOnClickListener);
        this.hjv = (TextView) view.findViewById(R.id.rank_name);
        this.hjv.getPaint().setFakeBoldText(true);
        this.hjw = (TextView) view.findViewById(R.id.top_user_name);
        this.hjx = (TextView) view.findViewById(R.id.rank_data);
        this.hjy = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.hjz = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.hjA = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.hjB = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.hjC = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.hjD = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.hjD.setErrorRes(R.drawable.pic_list_avatar);
        this.hjy.setImageDrawable(SvgManager.baR().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.hjz.setImageDrawable(SvgManager.baR().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.hjA.setImageDrawable(SvgManager.baR().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.hjB.setImageDrawable(SvgManager.baR().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.hjC.setImageDrawable(SvgManager.baR().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.hjE = (TextView) view.findViewById(R.id.text_compute_method);
        this.hjE.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.hjF = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.hjF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    ap apVar = new ap("c13671");
                    apVar.t("fid", a.this.mForumId);
                    TiebaStatic.log(apVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.hjL);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.hjG = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.hjH = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.hjK = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.hjI = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.hjI.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.hjI.setStrokeStyle(1);
        this.hjI.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hjI.setLoadImageType(12);
        this.hjJ = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hjM = aVar;
        if (aVar != null) {
            this.hjv.setText(aVar.hkH);
            if (aVar.hkJ != null) {
                String str = aVar.hkI;
                if (ae.getTextLengthWithEmoji(aVar.hkI) > 10) {
                    str = ae.subStringWithEmoji(aVar.hkI, 10) + StringHelper.STRING_MORE;
                }
                this.hjw.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.hkK == 0) {
                this.hjx.setVisibility(8);
            } else {
                this.hjx.setVisibility(0);
                this.hjx.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), as.cz(aVar.hkK * 1000)));
            }
            this.hjD.setImage(aVar.hkL, eK(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.hkM != null && !z && !TextUtils.isEmpty(aVar.hkM.tieba_name)) {
                this.hjF.setVisibility(0);
                this.hjH.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.hkM.tieba_name));
                List<String> ch = ch(aVar.hkM.user_rank);
                this.hjI.setData(ch);
                ci(ch);
                this.hjL = aVar.hkM.tieba_name;
                if (this.mForumId > 0) {
                    ap apVar = new ap("c13670");
                    apVar.t("fid", this.mForumId);
                    TiebaStatic.log(apVar);
                    return;
                }
                return;
            }
            this.hjF.setVisibility(8);
        }
    }

    private List<String> ch(List<User> list) {
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

    private void ci(List<String> list) {
        int count = x.getCount(list);
        if (count == 0) {
            this.hjK.setVisibility(8);
            return;
        }
        this.hjK.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hjK.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.hjK.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.hjE, R.color.cp_cont_d);
            SvgManager.baR().a(this.hjG, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.hjK, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.baR().a(this.hjJ, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.hjH, R.color.cp_cont_b);
            this.hjI.onChangeSkinType();
        }
    }

    public BdUniqueId eK(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
