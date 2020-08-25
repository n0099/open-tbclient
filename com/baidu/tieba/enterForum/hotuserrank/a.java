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
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes16.dex */
public class a {
    private View htD;
    private ImageView hwA;
    private ImageView hwB;
    private String hwC;
    private com.baidu.tieba.enterForum.hotuserrank.a.a hwD;
    private TextView hwm;
    private TextView hwn;
    private TextView hwo;
    private ImageView hwp;
    private ImageView hwq;
    private ImageView hwr;
    private ImageView hws;
    private ImageView hwt;
    private IrregularImageView hwu;
    private TextView hwv;
    private RelativeLayout hww;
    private ImageView hwx;
    private TextView hwy;
    private ImageOverlayView hwz;
    private final String mCategory;
    private final long mForumId;
    private View mRootView;
    private int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.this.htD.getId() && a.this.hwD != null && a.this.hwD.hxA != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.mRootView.getContext(), a.this.hwD.hxA.getUserId(), a.this.hwD.hxA.getName_show())));
                if (!TextUtils.isEmpty(a.this.mCategory)) {
                    aq aqVar = new aq("c13659");
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.dD("resource_id", a.this.hwD.hxy);
                    aqVar.dD("friend_uid", a.this.hwD.hxA.rankNum);
                    TiebaStatic.log(aqVar);
                    return;
                }
                aq aqVar2 = new aq("c13683");
                aqVar2.dD("uid", a.this.hwD.hxA.getUserId());
                aqVar2.u("fid", a.this.mForumId);
                TiebaStatic.log(aqVar2);
            }
        }
    };

    public a(View view, String str, long j) {
        this.mRootView = view;
        this.mCategory = str;
        this.mForumId = j;
        this.htD = view.findViewById(R.id.top_container);
        this.htD.setOnClickListener(this.mOnClickListener);
        this.hwm = (TextView) view.findViewById(R.id.rank_name);
        this.hwm.getPaint().setFakeBoldText(true);
        this.hwn = (TextView) view.findViewById(R.id.top_user_name);
        this.hwo = (TextView) view.findViewById(R.id.rank_data);
        this.hwp = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.hwq = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.hwr = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.hws = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.hwt = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        this.hwu = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.hwu.setErrorRes(R.drawable.pic_list_avatar);
        this.hwp.setImageDrawable(SvgManager.bjq().i(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.hwq.setImageDrawable(SvgManager.bjq().i(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.hwr.setImageDrawable(SvgManager.bjq().i(R.drawable.svg_pic_mask_list_line, 1, false));
        this.hws.setImageDrawable(SvgManager.bjq().i(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.hwt.setImageDrawable(SvgManager.bjq().i(R.drawable.svg_pic_mask_list_line2, 1, false));
        this.hwv = (TextView) view.findViewById(R.id.text_compute_method);
        this.hwv.setText(this.mRootView.getResources().getString(R.string.hot_user_rank_influence_desc));
        this.hww = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.hww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.hotuserrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.mForumId > 0) {
                    aq aqVar = new aq("c13671");
                    aqVar.u("fid", a.this.mForumId);
                    TiebaStatic.log(aqVar);
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.mRootView.getContext());
                hotUserRankActivityConfig.setCategory(a.this.hwC);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
            }
        });
        this.hwx = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.hwy = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.hwB = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.hwz = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.hwz.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.cp_mask_c_alpha50, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.hwz.setStrokeStyle(1);
        this.hwz.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hwz.setLoadImageType(12);
        this.hwA = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a(com.baidu.tieba.enterForum.hotuserrank.a.a aVar, boolean z) {
        this.hwD = aVar;
        if (aVar != null) {
            this.hwm.setText(aVar.hxy);
            if (aVar.hxA != null) {
                String str = aVar.hxz;
                if (ae.getTextLengthWithEmoji(aVar.hxz) > 10) {
                    str = ae.subStringWithEmoji(aVar.hxz, 10) + StringHelper.STRING_MORE;
                }
                this.hwn.setText(String.format(this.mRootView.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
            }
            if (aVar.hxB == 0) {
                this.hwo.setVisibility(8);
            } else {
                this.hwo.setVisibility(0);
                this.hwo.setText(String.format(this.mRootView.getContext().getString(R.string.hot_user_rank_data), at.cK(aVar.hxB * 1000)));
            }
            this.hwu.setImage(aVar.hxC, eU(this.mRootView.getContext()), R.drawable.mask_list_avatar);
            if (aVar.hxD != null && !z && !TextUtils.isEmpty(aVar.hxD.tieba_name)) {
                this.hww.setVisibility(0);
                this.hwy.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.hxD.tieba_name));
                List<String> cj = cj(aVar.hxD.user_rank);
                this.hwz.setData(cj);
                ck(cj);
                this.hwC = aVar.hxD.tieba_name;
                if (this.mForumId > 0) {
                    aq aqVar = new aq("c13670");
                    aqVar.u("fid", this.mForumId);
                    TiebaStatic.log(aqVar);
                    return;
                }
                return;
            }
            this.hww.setVisibility(8);
        }
    }

    private List<String> cj(List<User> list) {
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

    private void ck(List<String> list) {
        int count = y.getCount(list);
        if (count == 0) {
            this.hwB.setVisibility(8);
            return;
        }
        this.hwB.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int dimensionPixelOffset2 = dimensionPixelOffset - ((3 - count) * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwB.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset2;
            this.hwB.setLayoutParams(layoutParams);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.hwv, R.color.cp_cont_d);
            SvgManager.bjq().a(this.hwx, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.hwB, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.bjq().a(this.hwA, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.hwy, R.color.cp_cont_b);
            this.hwz.onChangeSkinType();
        }
    }

    public BdUniqueId eU(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }
}
