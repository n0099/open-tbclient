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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private View dfT;
    private TbPageContext<BaseFragmentActivity> eIc;
    private TextView gQC;
    private HeadImageView gms;
    private BdListView hGa;
    private b hGb;
    private TextView hGc;
    private TbImageView hGd;
    private RelativeLayout hGe;
    private ImageView hGf;
    private LinearLayout hGg;
    private AlaNetRefreshView hGh;
    private RelativeLayout hGi;
    private TextView hGj;
    private InterfaceC0700a hGk;
    private List<AlaLiveMarkData> hGl = new ArrayList();
    private b.a hGm = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hGk != null) {
                a.this.hGk.a(bVar);
            }
        }
    };
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0700a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0700a interfaceC0700a) {
        this.eIc = tbPageContext;
        this.hGk = interfaceC0700a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eIc.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gms = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hGc = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hGd = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hGi = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hGg = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hGj = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hGf = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.gQC = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dfT = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hGa = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hGb = new b(this.eIc, this.hGm);
        this.hGa.setAdapter((ListAdapter) this.hGb);
        this.hGe = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hGa.setEmptyView(this.hGe);
        this.gms.setIsRound(true);
        this.gms.setDefaultBgResource(R.color.transparent);
        this.gms.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hGd.setDefaultBgResource(R.color.transparent);
        this.hGd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        ap.setViewTextColor(this.hGc, (int) R.color.white_alpha70);
        ap.setViewTextColor(this.hGj, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.gQC, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hGf.setAlpha(0.4f);
            this.dfT.setBackgroundColor(this.eIc.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hGf.setAlpha(1.0f);
        this.dfT.setBackgroundColor(this.eIc.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hGb != null && list != null) {
            this.hGb.setData(list);
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
                format = String.format(this.eIc.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eIc.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aw(currentPortrait, str, format);
            int dimension = (int) this.eIc.getResources().getDimension(R.dimen.ds32);
            if (this.hGl != null && this.hGl.size() > 0) {
                this.hGl.clear();
            }
            if (this.hGg != null) {
                this.hGg.removeAllViews();
                this.hGl = alaUserInfoData.live_mark_info_new;
                if (this.hGl != null) {
                    for (int i = 0; i < this.hGl.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eIc.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hGl.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eIc.getResources().getDimension(R.dimen.ds12);
                        this.hGg.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aw(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eIc.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hGl != null && this.hGl.size() > 0) {
            this.hGl.clear();
        }
        if (this.hGg != null) {
            this.hGg.removeAllViews();
        }
    }

    private void aw(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gms.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.mS().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hGd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hGd.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gms.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.hGd.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hGc.setText(str3);
        } else {
            this.hGc.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eIc != null) {
            if (this.hGh == null) {
                this.hGh = new AlaNetRefreshView(this.eIc.getPageActivity());
            }
            this.hGh.setImageResource(i);
            this.hGh.setNetFailTipText(this.eIc.getString(i2));
            this.hGh.onChangeSkinType();
            this.hGh.setIsShowRefreshButton(z);
            if (z) {
                this.hGh.setOnRefreshClickListener(onClickListener);
            }
            this.hGh.attachView(this.hGi);
        }
    }

    public void Wk() {
        if (this.hGh != null) {
            this.hGh.dettachView(this.hGi);
        }
    }
}
