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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes22.dex */
public class a {
    private View iih;
    private TextView ikQ;
    private TextView ikR;
    private TextView ikS;
    private ImageView ikT;
    private ImageView ikU;
    private ImageView ikV;
    private ImageView ikW;
    private ImageView ikX;
    private IrregularImageView ikY;
    private TextView ikZ;
    private RelativeLayout ila;
    private ImageView ilb;
    private TextView ilc;
    private ImageOverlayView ild;
    private ImageView ile;
    private ImageView ilf;
    private String ilg;
    private com.baidu.tieba.enterForum.hotuserrank.a.a ilh;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.iih.getId() && a.this.ilh != null && a.this.ilh.imc != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.ilh.imc.getUserId(), a.this.ilh.imc.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dR("resource_id", a.this.ilh.rankName);
                    aqVar.dR("friend_uid", a.this.ilh.imc.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dR("uid", a.this.ilh.imc.getUserId());
                aqVar2.w("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.iih = view.findViewById(R.id.top_container);
        this.iih.setOnClickListener(this.mOnClickListener);
        this.ikQ = (TextView) view.findViewById(R.id.rank_name);
        this.ikQ.getPaint().setFakeBoldText(true);
        this.ikR = (TextView) view.findViewById(R.id.top_user_name);
        this.ikS = (TextView) view.findViewById(R.id.rank_data);
        this.ikT = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.ikU = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.ikV = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.ikW = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.ikX = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.ikY = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.ikY.setErrorRes(R.drawable.pic_list_avatar);
        this.ikT.setImageDrawable(SvgManager.brn().j(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.ikU.setImageDrawable(SvgManager.brn().j(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.ikV.setImageDrawable(SvgManager.brn().j(R.drawable.svg_pic_mask_list_line, 1, false));
        this.ikW.setImageDrawable(SvgManager.brn().j(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.ikX.setImageDrawable(SvgManager.brn().j(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.ikZ = (TextView) view.findViewById(R.id.text_compute_method);
        this.ikZ.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.ila = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.ila.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.w("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.ilg);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.ilb = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.ilc = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.ilf = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.ild = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.ild.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.ild.setStrokeStyle(1);
        this.ild.setFirstImageStrokeColor(R.color.cp_other_h);
        this.ild.setLoadImageType(12);
        this.ile = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.ilh = aVar;
        if (aVar != null) {
            this.ikQ.setText(aVar.rankName);
            if (aVar.imc != null) {
                String str = aVar.imb;
                if (af.getTextLengthWithEmoji(aVar.imb) > 10) {
                    str = af.subStringWithEmoji(aVar.imb, 10) + StringHelper.STRING_MORE;
                }
                this.ikR.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.imd == 0) {
                this.ikS.setVisibility(8);
            } else {
                this.ikS.setVisibility(0);
                this.ikS.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.dr(aVar.imd * 1000)));
            }
            this.ikY.setImage(aVar.ime, fi(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.imf != null && !z && !TextUtils.isEmpty(aVar.imf.tieba_name)) {
                this.ila.setVisibility(0);
                this.ilc.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.imf.tieba_name));
                List<String> cJ = cJ(aVar.imf.user_rank);
                this.ild.setData(cJ);
                cK(cJ);
                this.ilg = aVar.imf.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.w("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.ila.setVisibility(8);
        }
    }

    private List<String> cJ(List<User> list) {
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

    private void cK(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.ilf.setVisibility(8);
            return;
        }
        this.ilf.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilf.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.ilf.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ikZ, R.color.cp_cont_d);
            SvgManager.brn().a(this.ilb, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.ilf, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.brn().a(this.ile, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.ilc, R.color.cp_cont_b);
            this.ild.onChangeSkinType();
        }
    }

    public BdUniqueId fi(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
