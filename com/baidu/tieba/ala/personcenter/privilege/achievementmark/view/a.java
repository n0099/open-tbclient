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
    private TbPageContext<BaseFragmentActivity> cVi;
    private View czu;
    private TextView eLX;
    private HeadImageView eou;
    private TextView fwA;
    private InterfaceC0480a fwB;
    private List<AlaLiveMarkData> fwC = new ArrayList();
    private b.a fwD = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.fwB != null) {
                a.this.fwB.a(bVar);
            }
        }
    };
    private BdListView fwr;
    private b fws;
    private TextView fwt;
    private TbImageView fwu;
    private RelativeLayout fwv;
    private ImageView fww;
    private LinearLayout fwx;
    private AlaNetRefreshView fwy;
    private RelativeLayout fwz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0480a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0480a interfaceC0480a) {
        this.cVi = tbPageContext;
        this.fwB = interfaceC0480a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cVi.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.eou = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.fwt = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.fwu = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.fwz = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.fwx = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.fwA = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.fww = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eLX = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.czu = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.fwr = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.fws = new b(this.cVi, this.fwD);
        this.fwr.setAdapter((ListAdapter) this.fws);
        this.fwv = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.fwr.setEmptyView(this.fwv);
        this.eou.setIsRound(true);
        this.eou.setDefaultBgResource(R.color.transparent);
        this.eou.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fwu.setDefaultBgResource(R.color.transparent);
        this.fwu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.fwt, (int) R.color.white_alpha70);
        am.setViewTextColor(this.fwA, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eLX, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.fww.setAlpha(0.4f);
            this.czu.setBackgroundColor(this.cVi.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.fww.setAlpha(1.0f);
        this.czu.setBackgroundColor(this.cVi.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.fws != null && list != null) {
            this.fws.setData(list);
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
                format = String.format(this.cVi.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cVi.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ah(currentPortrait, str, format);
            int dimension = (int) this.cVi.getResources().getDimension(R.dimen.ds32);
            if (this.fwC != null && this.fwC.size() > 0) {
                this.fwC.clear();
            }
            if (this.fwx != null) {
                this.fwx.removeAllViews();
                this.fwC = alaUserInfoData.live_mark_info_new;
                if (this.fwC != null) {
                    for (int i = 0; i < this.fwC.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cVi.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.fwC.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cVi.getResources().getDimension(R.dimen.ds12);
                        this.fwx.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ah(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cVi.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.fwC != null && this.fwC.size() > 0) {
            this.fwC.clear();
        }
        if (this.fwx != null) {
            this.fwx.removeAllViews();
        }
    }

    private void ah(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.eou.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gr().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.fwu.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.fwu.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.eou.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.fwu.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.fwt.setText(str3);
        } else {
            this.fwt.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cVi != null) {
            if (this.fwy == null) {
                this.fwy = new AlaNetRefreshView(this.cVi.getPageActivity());
            }
            this.fwy.setImageResource(i);
            this.fwy.setNetFailTipText(this.cVi.getString(i2));
            this.fwy.onChangeSkinType();
            this.fwy.setIsShowRefreshButton(z);
            if (z) {
                this.fwy.setOnRefreshClickListener(onClickListener);
            }
            this.fwy.attachView(this.fwz);
        }
    }

    public void bcy() {
        if (this.fwy != null) {
            this.fwy.dettachView(this.fwz);
        }
    }
}
