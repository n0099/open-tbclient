package com.baidu.tieba.homepage.concern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import d.b.b.e.p.l;
import d.b.h0.r.q.w0;
import d.b.h0.z0.b0;
import d.b.i0.p0.o0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class ConcernFragment extends BaseFragment implements o0 {

    /* renamed from: e  reason: collision with root package name */
    public ConcernPageView f16973e;

    /* renamed from: f  reason: collision with root package name */
    public ConcernPageView.l f16974f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16976h;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16975g = false;
    public CustomMessageListener i = new a(2001115);
    public final AntiHelper.k j = new b();
    public CustomMessageListener k = new c(2921414);
    public final CustomMessageListener l = new d(2001383);
    public final d.b.b.c.g.a m = new e(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f13695c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(ConcernFragment.this.getUniqueId())) {
                    return;
                }
                if (updateAttentionMessage.getData().k != null) {
                    if (AntiHelper.t(ConcernFragment.this.getActivity(), updateAttentionMessage.getData().k, ConcernFragment.this.j) != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                    }
                } else if (updateAttentionMessage.getData().f13693a && updateAttentionMessage.getData().f13696d) {
                    l.K(ConcernFragment.this.getActivity(), R.string.attention_success);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AntiHelper.k {
        public b() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (ConcernFragment.this.f16973e != null) {
                ConcernFragment.this.f16973e.G();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f16981e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f16982f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f16983g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ long f16984h;

            public a(PostWriteCallBackData postWriteCallBackData, long j, long j2, long j3) {
                this.f16981e = postWriteCallBackData;
                this.f16982f = j;
                this.f16983g = j2;
                this.f16984h = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int k = l.k(TbadkCoreApplication.getInst());
                int i = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setProZone(this.f16981e.getProZone());
                requestGetMyPostNetMessage.setParams(this.f16982f, this.f16983g, this.f16984h, k, i, f2, i2);
                requestGetMyPostNetMessage.setCallFrom(1);
                ConcernFragment.this.sendMessage(requestGetMyPostNetMessage);
            }
        }

        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            PostWriteCallBackData postWriteCallBackData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData()) == null) {
                return;
            }
            long f2 = d.b.b.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
            long f3 = d.b.b.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
            long f4 = d.b.b.e.m.b.f(d.b.i0.c3.q0.a.f().g(), 0L);
            if (f2 != 0 && f3 != 0 && f4 != 0) {
                d.b.b.e.m.e.a().postDelayed(new a(postWriteCallBackData, f3, f2, f4), 1000L);
            } else if (StringUtils.isNull(postWriteCallBackData.getVideoid())) {
            } else {
                WriteData writeData = postWriteCallBackData.writeDataForVideo;
                w0 w0Var = new w0();
                w0Var.G2(writeData);
                ConcernFragment.this.f16973e.y(w0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends d.b.b.c.g.a {
        public e(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
        @Override // d.b.b.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String errorString;
            String errorString2;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof RequestGetMyPostNetMessage) {
                    z = ((RequestGetMyPostNetMessage) extra).showErrorToast();
                    if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
                        GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                            errorString2 = ConcernFragment.this.getResources().getString(R.string.neterror);
                        } else {
                            errorString2 = getMyPostHttpResponseMessage.getErrorString();
                        }
                        if (z || getMyPostHttpResponseMessage.getError() == 0) {
                            ConcernFragment.this.I0(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                        GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                        if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                            errorString = ConcernFragment.this.getResources().getString(R.string.neterror);
                        } else {
                            errorString = getMyPostSocketResponseMessage.getErrorString();
                        }
                        if (z || getMyPostSocketResponseMessage.getError() == 0) {
                            ConcernFragment.this.I0(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!(responsedMessage instanceof GetMyPostHttpResponseMessage)) {
            }
        }
    }

    public ConcernFragment() {
    }

    @Override // d.b.i0.p0.o0
    public void A() {
    }

    @Override // d.b.i0.p0.o0
    public void F() {
    }

    public void H0() {
        this.f16973e.r();
    }

    public final void I0(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        User_Info user_Info;
        if (i != 0) {
            showToast(str);
            return;
        }
        DataRes dataRes = getMyPostResIdl.data;
        if (dataRes == null || dataRes.thread_info == null) {
            return;
        }
        w0 w0Var = new w0();
        ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
        User.Builder builder2 = new User.Builder(builder.author);
        J0(builder2, getMyPostResIdl.data.user_info);
        User user = builder.author;
        if (user == null || TextUtils.isEmpty(user.name)) {
            builder.author = builder2.build(true);
        }
        User user2 = builder.author;
        if (user2 != null && (user_Info = getMyPostResIdl.data.user_info) != null && user2.name.equals(user_Info.name)) {
            builder.author = builder2.build(true);
        }
        builder.fname = d.b.i0.c3.q0.a.f().h();
        builder.fid = Long.valueOf(d.b.b.e.m.b.f(d.b.i0.c3.q0.a.f().h(), 0L));
        w0Var.Q2(builder.build(true));
        this.f16973e.y(w0Var);
    }

    public final void J0(User.Builder builder, User_Info user_Info) {
        if (user_Info == null) {
            return;
        }
        Long l = user_Info.id;
        builder.id = l;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        if (l.longValue() == TbadkCoreApplication.getCurrentAccountId()) {
            builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        } else {
            builder.portrait = user_Info.portrait;
        }
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
        builder.new_god_data = user_Info.new_god_data;
    }

    @Override // d.b.i0.p0.o0
    public void K(b0 b0Var) {
        ConcernPageView concernPageView = this.f16973e;
        if (concernPageView != null) {
            concernPageView.setRecommendFrsNavigationAnimDispatcher(b0Var);
        }
    }

    public void K0(ConcernPageView.l lVar) {
        this.f16974f = lVar;
        this.f16973e.setCallback(lVar);
    }

    public void L0(ScrollFragmentTabHost scrollFragmentTabHost) {
        ConcernPageView concernPageView = this.f16973e;
        if (concernPageView != null) {
            concernPageView.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void M0() {
        ConcernPageView concernPageView = this.f16973e;
        if (concernPageView != null) {
            concernPageView.J();
        }
    }

    public void N0(tbclient.Userlike.DataRes dataRes, boolean z) {
        ConcernPageView concernPageView = this.f16973e;
        if (concernPageView != null) {
            concernPageView.R(dataRes, z);
        }
    }

    public void O0(String str, int i) {
        this.f16973e.S(str, i);
    }

    @Override // d.b.i0.p0.o0
    public void W() {
    }

    @Override // d.b.i0.p0.o0
    public void b0() {
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.f16973e.D(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a038";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.h0.k0.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(ListUtils.getItem(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.l.setTag(getBaseFragmentActivity().getUniqueId());
        this.l.setSelfListener(true);
        registerListener(this.l);
        this.m.getHttpMessageListener().setSelfListener(true);
        this.m.getSocketMessageListener().setSelfListener(true);
        registerListener(this.m);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f16973e.D(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f16973e.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f16973e.getParent()).removeView(this.f16973e);
            ConcernPageView.l lVar = this.f16974f;
            if (lVar != null) {
                this.f16973e.setCallback(lVar);
            }
        }
        this.f16973e.setPageUniqueId(getUniqueId());
        if (this.f16975g) {
            this.f16973e.x();
            this.f16975g = false;
        }
        return this.f16973e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.l);
        this.f16973e.E();
        this.f16975g = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        MessageManager.getInstance().unRegisterListener(this.i);
        MessageManager.getInstance().unRegisterListener(this.k);
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16973e.setTabInForeBackgroundState(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (!this.f16976h) {
                ConcernPageView concernPageView = this.f16973e;
                if (concernPageView != null) {
                    concernPageView.s();
                }
                this.f16976h = true;
            }
            this.f16973e.setViewForeground();
            return;
        }
        this.f16973e.H();
        H0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ConcernPageView concernPageView = this.f16973e;
        if (concernPageView != null) {
            concernPageView.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // d.b.i0.p0.o0
    public void w() {
        if (this.f16976h) {
            this.f16973e.K();
        }
    }

    @SuppressLint({"ValidFragment"})
    public ConcernFragment(Context context) {
        ConcernPageView concernPageView = new ConcernPageView(context);
        this.f16973e = concernPageView;
        concernPageView.x();
        registerListener(this.i);
        registerListener(this.k);
    }
}
