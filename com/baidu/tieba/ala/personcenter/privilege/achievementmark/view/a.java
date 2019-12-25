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
/* loaded from: classes2.dex */
public class a {
    private TbPageContext<BaseFragmentActivity> cQU;
    private View cvj;
    private TextView eGF;
    private HeadImageView ejh;
    private RelativeLayout fqA;
    private TextView fqB;
    private InterfaceC0468a fqC;
    private List<AlaLiveMarkData> fqD = new ArrayList();
    private b.a fqE = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.fqC != null) {
                a.this.fqC.a(bVar);
            }
        }
    };
    private BdListView fqs;
    private b fqt;
    private TextView fqu;
    private TbImageView fqv;
    private RelativeLayout fqw;
    private ImageView fqx;
    private LinearLayout fqy;
    private AlaNetRefreshView fqz;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0468a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0468a interfaceC0468a) {
        this.cQU = tbPageContext;
        this.fqC = interfaceC0468a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.cQU.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.ejh = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.fqu = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.fqv = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.fqA = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.fqy = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.fqB = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.fqx = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.eGF = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.cvj = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.fqs = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.fqt = new b(this.cQU, this.fqE);
        this.fqs.setAdapter((ListAdapter) this.fqt);
        this.fqw = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.fqs.setEmptyView(this.fqw);
        this.ejh.setIsRound(true);
        this.ejh.setDefaultBgResource(R.color.transparent);
        this.ejh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fqv.setDefaultBgResource(R.color.transparent);
        this.fqv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mName, (int) R.color.common_color_10310);
        am.setViewTextColor(this.fqu, (int) R.color.white_alpha70);
        am.setViewTextColor(this.fqB, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.eGF, (int) R.color.cp_cont_f);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.fqx.setAlpha(0.4f);
            this.cvj.setBackgroundColor(this.cQU.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.fqx.setAlpha(1.0f);
        this.cvj.setBackgroundColor(this.cQU.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.fqt != null && list != null) {
            this.fqt.setData(list);
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
                format = String.format(this.cQU.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.cQU.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            ag(currentPortrait, str, format);
            int dimension = (int) this.cQU.getResources().getDimension(R.dimen.ds32);
            if (this.fqD != null && this.fqD.size() > 0) {
                this.fqD.clear();
            }
            if (this.fqy != null) {
                this.fqy.removeAllViews();
                this.fqD = alaUserInfoData.live_mark_info_new;
                if (this.fqD != null) {
                    for (int i = 0; i < this.fqD.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.cQU.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.fqD.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.cQU.getResources().getDimension(R.dimen.ds12);
                        this.fqy.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ag(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.cQU.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.fqD != null && this.fqD.size() > 0) {
            this.fqD.clear();
        }
        if (this.fqy != null) {
            this.fqy.removeAllViews();
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.ejh.startLoad(str, 25, false);
            com.baidu.adp.lib.e.c.gs().a(str, 25, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.fqv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.fqv.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.ejh.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
            this.fqv.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.fqu.setText(str3);
        } else {
            this.fqu.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.cQU != null) {
            if (this.fqz == null) {
                this.fqz = new AlaNetRefreshView(this.cQU.getPageActivity());
            }
            this.fqz.setImageResource(i);
            this.fqz.setNetFailTipText(this.cQU.getString(i2));
            this.fqz.onChangeSkinType();
            this.fqz.setIsShowRefreshButton(z);
            if (z) {
                this.fqz.setOnRefreshClickListener(onClickListener);
            }
            this.fqz.attachView(this.fqA);
        }
    }

    public void aZK() {
        if (this.fqz != null) {
            this.fqz.dettachView(this.fqA);
        }
    }
}
