package com.baidu.tieba.ala.person.playbacks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.b;
import com.baidu.tieba.ala.person.view.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PersonPlayBacksListFragment extends BaseFragment {
    private Context context;
    private boolean hBA = true;
    private b hBz;
    private a hzo;
    private BdListView hzp;
    private d hzs;
    private boolean hzt;
    private Object hzu;
    private AlaListEmptyView hzv;
    private String userId;

    public static PersonPlayBacksListFragment z(String str, Object obj) {
        PersonPlayBacksListFragment personPlayBacksListFragment = new PersonPlayBacksListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", str);
        personPlayBacksListFragment.setArguments(bundle);
        personPlayBacksListFragment.au(obj);
        return personPlayBacksListFragment;
    }

    public void au(Object obj) {
        this.hzu = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.userId = getArguments().getString("user_id");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.ala_fragment_person_list, (ViewGroup) null);
        initData();
        al(inflate);
        initListener();
        ciC();
        return inflate;
    }

    private void bgA() {
        b(true, this.hzu);
    }

    private void initListener() {
        this.hzp.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonPlayBacksListFragment.this.hBA) {
                    PersonPlayBacksListFragment.this.hzs.hide();
                } else {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonPlayBacksListFragment.this.hzo != null && PersonPlayBacksListFragment.this.hzo.getCount() == 0) {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.hzo.a(new a.b() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.b
            public void a(AlaLiveInfoData alaLiveInfoData, View view) {
                if (PersonPlayBacksListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    PersonCardActivity personCardActivity = (PersonCardActivity) PersonPlayBacksListFragment.this.getPageContext().getOrignalPage();
                    if (!personCardActivity.Id(TbadkCoreApplication.getCurrentAccount())) {
                        PersonPlayBacksListFragment.this.a(PersonPlayBacksListFragment.this.getPageContext(), alaLiveInfoData);
                    } else {
                        BdUtilHelper.showToast(personCardActivity.getActivity(), a.h.ala_person_owner_is_living);
                    }
                }
            }
        });
    }

    private void initData() {
        this.hBz = new b(getPageContext());
        this.hBz.a(new b.a() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.4
            @Override // com.baidu.tieba.ala.person.c.b.a
            public void a(com.baidu.tieba.ala.person.a.d dVar) {
                if (dVar != null) {
                    PersonPlayBacksListFragment.this.b(PersonPlayBacksListFragment.this.hzt, dVar);
                    if (PersonPlayBacksListFragment.this.hzt) {
                        PersonPlayBacksListFragment.this.hzt = false;
                        return;
                    }
                    return;
                }
                PersonPlayBacksListFragment.this.showToast(a.h.ala_person_load_fail);
                PersonPlayBacksListFragment.this.hzs.wT(a.h.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.b.a
            public void onFail(String str) {
                PersonPlayBacksListFragment.this.showToast(str);
                PersonPlayBacksListFragment.this.hzo.a(true, null, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof com.baidu.tieba.ala.person.a.d)) {
            this.hBA = ((com.baidu.tieba.ala.person.a.d) obj).hzS.has_more == 1;
            if (((com.baidu.tieba.ala.person.a.d) obj).hzS.has_more != 1) {
                this.hzs.hide();
            } else {
                this.hzs.sf(a.h.sdk_loading);
            }
            this.hzo.a(z, ((com.baidu.tieba.ala.person.a.d) obj).ciF(), 2);
        }
    }

    private void ciC() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.hzo.a(true, null, 2);
        } else if (this.hBz != null) {
            if (this.hzu == null) {
                this.hBz.setCurrentPage(-1);
                this.hzt = true;
                loadData();
                return;
            }
            this.hBz.setCurrentPage(0);
            bgA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.hBA) {
            this.hBz.setUid(this.userId);
            this.hBz.Ie(this.userId);
        }
    }

    private void al(View view) {
        this.hzp = (BdListView) view.findViewById(a.f.listview);
        this.hzo = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.hzp.setAdapter((ListAdapter) this.hzo);
        this.hzs = new d(getPageContext());
        this.hzs.createView();
        this.hzp.setNextPage(this.hzs);
        this.hzs.display();
        this.hzs.sf(a.h.sdk_loading);
        this.hzv = (AlaListEmptyView) view.findViewById(a.f.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hzv.setParams(a.e.sdk_pic_live_empty01_hk, a.h.hk_ala_person_no_playbacks);
        } else {
            this.hzv.setParams(a.e.sdk_pic_live_empty04_qm, a.h.hk_ala_person_no_playbacks);
        }
        this.hzp.setEmptyView(this.hzv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, AlaLiveInfoData alaLiveInfoData) {
        if (tbPageContext != null && alaLiveInfoData != null) {
            long j = alaLiveInfoData.user_id;
            String nameShow = alaLiveInfoData.getNameShow();
            String str = alaLiveInfoData.feed_id;
            String str2 = alaLiveInfoData.media_url;
            String str3 = alaLiveInfoData.media_subtitle;
            String str4 = alaLiveInfoData.media_pic;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_ID, j);
                jSONObject.put(TbEnum.SystemMessage.KEY_USER_NAME, nameShow);
                jSONObject.put("feedId", str);
                jSONObject.put("mediaUrl", str2);
                jSONObject.put("mediaTitle", str3);
                jSONObject.put("mediaPic", str4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
            if (buildJumpExtra != null) {
                buildJumpExtra.jumpToPlayCallback(tbPageContext.getPageActivity(), jSONObject.toString());
                ((PersonCardActivity) getPageContext().getOrignalPage()).finish();
            }
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
