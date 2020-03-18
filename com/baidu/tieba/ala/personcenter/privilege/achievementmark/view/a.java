package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> cVv;
    private View czF;
    private TextView eMt;
    private HeadImageView eoL;
    private BdListView fwX;
    private b fwY;
    private TextView fwZ;
    private TbImageView fxa;
    private RelativeLayout fxb;
    private ImageView fxc;
    private LinearLayout fxd;
    private AlaNetRefreshView fxe;
    private RelativeLayout fxf;
    private TextView fxg;
    private InterfaceC0480a fxh;
    private List<AlaLiveMarkData> fxi = new ArrayList();
    private b.a fxj = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.fxh != null) {
                a.this.fxh.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0480a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0480a interfaceC0480a) {
        this.cVv = tbPageContext;
        this.fxh = interfaceC0480a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cVv.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eoL = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.fwZ = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.fxa = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.fxf = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.fxd = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.fxg = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.fxc = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eMt = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.czF = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.fwX = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.fwY = new b(this.cVv, this.fxj);
        this.fwX.setAdapter((ListAdapter) this.fwY);
        this.fxb = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.fwX.setEmptyView(this.fxb);
        this.eoL.setIsRound(true);
        this.eoL.setDefaultBgResource(R.color.transparent);
        this.eoL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fxa.setDefaultBgResource(R.color.transparent);
        this.fxa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.fwZ, (int) R.color.white_alpha70);
        am.setViewTextColor(this.fxg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eMt, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.fxc.setAlpha(0.4f);
            this.czF.setBackgroundColor(this.cVv.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.fxc.setAlpha(1.0f);
        this.czF.setBackgroundColor(this.cVv.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.fwY != null && list != null) {
            this.fwY.setData(list);
        }
        a(alaUserInfoData);
    }

    private void a(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkApplication.getCurrentAccountNameShow();
            }
            String currentPortrait = alaUserInfoData.portrait == null ? TbadkApplication.getCurrentPortrait() : alaUserInfoData.portrait;
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.cVv.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cVv.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ah(currentPortrait, str, format);
            int dimension = (int) this.cVv.getResources().getDimension(R.dimen.ds32);
            if (this.fxi != null && this.fxi.size() > 0) {
                this.fxi.clear();
            }
            if (this.fxd != null) {
                this.fxd.removeAllViews();
                this.fxi = alaUserInfoData.live_mark_info_new;
                if (this.fxi != null) {
                    for (int i = 0; i < this.fxi.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cVv.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.fxi.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cVv.getResources().getDimension(R.dimen.ds12);
                        this.fxd.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ah(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cVv.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.fxi != null && this.fxi.size() > 0) {
            this.fxi.clear();
        }
        if (this.fxd != null) {
            this.fxd.removeAllViews();
        }
    }

    private void ah(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eoL.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.fxa.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.fxa.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eoL.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.fxa.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.fwZ.setText(str3);
        } else {
            this.fwZ.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cVv != null) {
            if (this.fxe == null) {
                this.fxe = new AlaNetRefreshView(this.cVv.getPageActivity());
            }
            this.fxe.setImageResource(i);
            this.fxe.setNetFailTipText(this.cVv.getString(i2));
            this.fxe.onChangeSkinType();
            this.fxe.setIsShowRefreshButton(z);
            if (z) {
                this.fxe.setOnRefreshClickListener(onClickListener);
            }
            this.fxe.attachView(this.fxf);
        }
    }

    public void bcC() {
        if (this.fxe != null) {
            this.fxe.dettachView(this.fxf);
        }
    }
}
