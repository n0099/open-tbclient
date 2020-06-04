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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.BaseFragment;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.u.a;
import com.baidu.live.view.AlaListEmptyView;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a.e;
import com.baidu.tieba.ala.person.adapter.a;
import com.baidu.tieba.ala.person.c.b;
import com.baidu.tieba.ala.person.view.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PersonPlayBacksListFragment extends BaseFragment {
    private Context context;
    private a gkq;
    private BdListView gkr;
    private d gku;
    private boolean gkv;
    private Object gkw;
    private AlaListEmptyView gkx;
    private b gmD;
    private boolean gmE = true;
    private String userId;

    public static PersonPlayBacksListFragment A(String str, Object obj) {
        PersonPlayBacksListFragment personPlayBacksListFragment = new PersonPlayBacksListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", str);
        personPlayBacksListFragment.setArguments(bundle);
        personPlayBacksListFragment.an(obj);
        return personPlayBacksListFragment;
    }

    public void an(Object obj) {
        this.gkw = obj;
    }

    @Override // com.baidu.live.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext().getPageActivity();
        this.userId = getArguments().getString("user_id");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.ala_fragment_person_list, (ViewGroup) null);
        initData();
        ag(inflate);
        initListener();
        bHX();
        return inflate;
    }

    private void aLL() {
        b(true, this.gkw);
    }

    private void initListener() {
        this.gkr.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.1
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (!PersonPlayBacksListFragment.this.gmE) {
                    PersonPlayBacksListFragment.this.gku.hide();
                } else {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.gku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PersonPlayBacksListFragment.this.gkq != null && PersonPlayBacksListFragment.this.gkq.getCount() == 0) {
                    PersonPlayBacksListFragment.this.loadData();
                }
            }
        });
        this.gkq.a(new a.b() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.3
            @Override // com.baidu.tieba.ala.person.adapter.a.b
            public void a(AlaLiveInfoData alaLiveInfoData, View view) {
                if (PersonPlayBacksListFragment.this.getPageContext().getOrignalPage() instanceof PersonCardActivity) {
                    PersonCardActivity personCardActivity = (PersonCardActivity) PersonPlayBacksListFragment.this.getPageContext().getOrignalPage();
                    if (!personCardActivity.CS(TbadkCoreApplication.getCurrentAccount())) {
                        PersonPlayBacksListFragment.this.a(PersonPlayBacksListFragment.this.getPageContext(), alaLiveInfoData);
                    } else {
                        BdUtilHelper.showToast(personCardActivity.getActivity(), a.i.ala_person_owner_is_living);
                    }
                }
            }
        });
    }

    private void initData() {
        this.gmD = new b(getPageContext());
        this.gmD.a(new b.a() { // from class: com.baidu.tieba.ala.person.playbacks.PersonPlayBacksListFragment.4
            @Override // com.baidu.tieba.ala.person.c.b.a
            public void a(e eVar) {
                if (eVar != null) {
                    PersonPlayBacksListFragment.this.b(PersonPlayBacksListFragment.this.gkv, eVar);
                    if (PersonPlayBacksListFragment.this.gkv) {
                        PersonPlayBacksListFragment.this.gkv = false;
                        return;
                    }
                    return;
                }
                PersonPlayBacksListFragment.this.showToast(a.i.ala_person_load_fail);
                PersonPlayBacksListFragment.this.gku.rL(a.i.ala_person_load_fail_click);
            }

            @Override // com.baidu.tieba.ala.person.c.b.a
            public void onFail(String str) {
                PersonPlayBacksListFragment.this.showToast(str);
                PersonPlayBacksListFragment.this.gkq.a(true, null, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (obj != null && (obj instanceof e)) {
            this.gmE = ((e) obj).gkU.has_more == 1;
            if (((e) obj).gkU.has_more != 1) {
                this.gku.hide();
            } else {
                this.gku.nz(a.i.sdk_loading);
            }
            this.gkq.a(z, ((e) obj).bIa(), 2);
        }
    }

    private void bHX() {
        if (JavaTypesHelper.toLong(this.userId, 0L) == 0) {
            this.gkq.a(true, null, 2);
        } else if (this.gmD != null) {
            if (this.gkw == null) {
                this.gmD.setCurrentPage(-1);
                this.gkv = true;
                loadData();
                return;
            }
            this.gmD.setCurrentPage(0);
            aLL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        if (this.gmE) {
            this.gmD.setUid(this.userId);
            this.gmD.CT(this.userId);
        }
    }

    private void ag(View view) {
        this.gkr = (BdListView) view.findViewById(a.g.listview);
        this.gkq = new com.baidu.tieba.ala.person.adapter.a(this.context, 1);
        this.gkr.setAdapter((ListAdapter) this.gkq);
        this.gku = new d(getPageContext());
        this.gku.createView();
        this.gkr.setNextPage(this.gku);
        this.gku.display();
        this.gku.nz(a.i.sdk_loading);
        this.gkx = (AlaListEmptyView) view.findViewById(a.g.emptyview);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gkx.setParams(a.f.sdk_pic_live_empty01_hk, a.i.hk_ala_person_no_playbacks);
        } else {
            this.gkx.setParams(a.f.sdk_pic_live_empty04_qm, a.i.hk_ala_person_no_playbacks);
        }
        this.gkr.setEmptyView(this.gkx);
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
