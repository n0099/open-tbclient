package com.baidu.tieba.ala.personcenter.privilege.achievementmark.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.c;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private View dlt;
    private TbPageContext<BaseFragmentActivity> eSJ;
    private HeadImageView gAD;
    private BdListView hXe;
    private b hXf;
    private TextView hXg;
    private TbImageView hXh;
    private RelativeLayout hXi;
    private ImageView hXj;
    private LinearLayout hXk;
    private AlaNetRefreshView hXl;
    private RelativeLayout hXm;
    private TextView hXn;
    private InterfaceC0688a hXo;
    private List<AlaLiveMarkData> hXp = new ArrayList();
    private b.a hXq = new b.a() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.2
        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.b.a
        public void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar) {
            if (a.this.hXo != null) {
                a.this.hXo.a(bVar);
            }
        }
    };
    private TextView hgG;
    private TextView mName;
    private View mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0688a {
        void a(com.baidu.tieba.ala.personcenter.privilege.achievementmark.a.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, InterfaceC0688a interfaceC0688a) {
        this.eSJ = tbPageContext;
        this.hXo = interfaceC0688a;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, (int) this.eSJ.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.gAD = (HeadImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.mName = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.hXg = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.hXh = (TbImageView) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.hXm = (RelativeLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.hXk = (LinearLayout) this.mRootView.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.hXn = (TextView) this.mRootView.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.hXj = (ImageView) this.mRootView.findViewById(R.id.empty_image);
        this.hgG = (TextView) this.mRootView.findViewById(R.id.empty_text);
        this.dlt = this.mRootView.findViewById(R.id.ala_person_center_privilege_mask);
        this.hXe = (BdListView) this.mRootView.findViewById(R.id.ala_person_center_privilege_mark_list);
        this.hXf = new b(this.eSJ, this.hXq);
        this.hXe.setAdapter((ListAdapter) this.hXf);
        this.hXi = (RelativeLayout) this.mRootView.findViewById(R.id.emptyview);
        this.hXe.setEmptyView(this.hXi);
        this.gAD.setIsRound(true);
        this.gAD.setDefaultBgResource(R.color.transparent);
        this.gAD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXh.setDefaultBgResource(R.color.transparent);
        this.hXh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setViewTextColor(this.mName, R.color.common_color_10310);
        ao.setViewTextColor(this.hXg, R.color.white_alpha70);
        ao.setViewTextColor(this.hXn, R.color.CAM_X0109);
        ao.setViewTextColor(this.hgG, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.hXj.setAlpha(0.4f);
            this.dlt.setBackgroundColor(this.eSJ.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.hXj.setAlpha(1.0f);
        this.dlt.setBackgroundColor(this.eSJ.getResources().getColor(R.color.black_alpha30));
    }

    public void a(AlaUserInfoData alaUserInfoData, List<c> list) {
        if (this.hXf != null && list != null) {
            this.hXf.setData(list);
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
                format = String.format(this.eSJ.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.eSJ.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            aA(currentPortrait, str, format);
            int dimension = (int) this.eSJ.getResources().getDimension(R.dimen.ds32);
            if (this.hXp != null && this.hXp.size() > 0) {
                this.hXp.clear();
            }
            if (this.hXk != null) {
                this.hXk.removeAllViews();
                this.hXp = alaUserInfoData.live_mark_info_new;
                if (this.hXp != null) {
                    for (int i = 0; i < this.hXp.size(); i++) {
                        TbImageView tbImageView = new TbImageView(this.eSJ.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.startLoad(this.hXp.get(i).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.eSJ.getResources().getDimension(R.dimen.ds12);
                        this.hXk.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        aA(TbadkApplication.getCurrentPortrait(), TbadkApplication.getCurrentAccountNameShow(), String.format(this.eSJ.getString(R.string.ala_achievement_mark_get_text), 0));
        if (this.hXp != null && this.hXp.size() > 0) {
            this.hXp.clear();
        }
        if (this.hXk != null) {
            this.hXk.removeAllViews();
        }
    }

    private void aA(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.gAD.startLoad(str, 25, false);
            d.mx().a(str, 25, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str4, int i) {
                    super.onLoaded((AnonymousClass1) aVar, str4, i);
                    if (aVar != null && aVar.getRawBitmap() != null) {
                        a.this.hXh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        a.this.hXh.setImageBitmap(BitmapHelper.fastblur(aVar.getRawBitmap(), 15, 0.75f));
                    }
                }
            }, null);
        } else {
            this.gAD.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.hXh.startLoad(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.mName.setText(str2);
        } else {
            this.mName.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.hXg.setText(str3);
        } else {
            this.hXg.setText("");
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(int i, int i2, boolean z, View.OnClickListener onClickListener) {
        if (this.eSJ != null) {
            if (this.hXl == null) {
                this.hXl = new AlaNetRefreshView(this.eSJ.getPageActivity());
            }
            this.hXl.setImageResource(i);
            this.hXl.setNetFailTipText(this.eSJ.getString(i2));
            this.hXl.onChangeSkinType();
            this.hXl.setIsShowRefreshButton(z);
            if (z) {
                this.hXl.setOnRefreshClickListener(onClickListener);
            }
            this.hXl.attachView(this.hXm);
        }
    }

    public void Vq() {
        if (this.hXl != null) {
            this.hXl.dettachView(this.hXm);
        }
    }
}
