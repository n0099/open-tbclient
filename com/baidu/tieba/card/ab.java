package com.baidu.tieba.card;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
import tbclient.DeleteThreadInfo;
/* loaded from: classes20.dex */
public class ab extends com.baidu.tbadk.core.dialog.i {
    private bw ajX;
    private boolean ewm;
    private ForumManageModel hrC;
    private final com.baidu.adp.base.d hrJ;
    private com.baidu.tbadk.core.dialog.a hru;
    private final com.baidu.tbadk.core.dialog.k htb;
    private com.baidu.tbadk.core.dialog.a htc;
    private Dialog htd;
    private final List<com.baidu.tbadk.core.dialog.g> hte;
    private String htf;
    private String htg;
    private List<BlueCheckRadioButton> hth;
    final CompoundButton.OnCheckedChangeListener hti;
    private final k.c htj;
    private Context mContext;
    private TbPageContext mPageContext;

    public ab(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.htf = "0";
        this.htg = this.htf;
        this.ewm = false;
        this.hti = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.card.ab.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (z2 && (compoundButton.getTag() instanceof String)) {
                    ab.this.htg = (String) compoundButton.getTag();
                    if (ab.this.hth != null) {
                        for (BlueCheckRadioButton blueCheckRadioButton : ab.this.hth) {
                            String str = (String) blueCheckRadioButton.getTag();
                            if (str != null && ab.this.htg != null && !str.equals(ab.this.htg)) {
                                blueCheckRadioButton.setChecked(false);
                            }
                        }
                    }
                }
            }
        };
        this.hrJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.card.ab.7
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj != null && ab.this.hrC != null) {
                    switch (ab.this.hrC.getLoadDataMode()) {
                        case 0:
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            if (bVar == null || bVar.hGO != 0) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.delete_fail, new Object[0]));
                                return;
                            } else if (bVar.Qx) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, ab.this.ajX.getId()));
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.delete_success);
                                return;
                            } else {
                                String string = !TextUtils.isEmpty(bVar.mro) ? bVar.mro : ab.this.getString(R.string.delete_fail, new Object[0]);
                                if (bVar.mErrCode == 1211066) {
                                    if (ab.this.htc == null) {
                                        ab.this.htc = new com.baidu.tbadk.core.dialog.a(ab.this.mPageContext.getPageActivity());
                                        ab.this.htc.zV(string);
                                        ab.this.htc.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.card.ab.7.1
                                            @Override // com.baidu.tbadk.core.dialog.a.b
                                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                                if (aVar != null) {
                                                    aVar.dismiss();
                                                }
                                            }
                                        });
                                        ab.this.htc.id(true);
                                        ab.this.htc.b(ab.this.mPageContext);
                                    }
                                    ab.this.htc.bia();
                                    return;
                                }
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, string);
                                return;
                            }
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            if (dVar == null) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            } else if (dVar.Qx) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mro) ? dVar.mro : ab.this.getString(R.string.mute_success, new Object[0]));
                                return;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, !TextUtils.isEmpty(dVar.mro) ? dVar.mro : ab.this.getString(R.string.mute_fail, new Object[0]));
                                return;
                            }
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            ab.this.a(ab.this.hrC.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            if (gVar == null || !gVar.Qx) {
                                com.baidu.adp.lib.util.l.showToast(ab.this.mContext, ab.this.getString(R.string.operation_failed, new Object[0]));
                                return;
                            } else {
                                ab.this.an(gVar.mrr);
                                return;
                            }
                        default:
                            return;
                    }
                }
            }
        };
        this.htj = new k.c() { // from class: com.baidu.tieba.card.ab.8
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                ab.this.dismiss();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.network_not_available);
                    return;
                }
                if (i == 1) {
                    if (ab.this.ajX != null && ab.this.ajX.bfy() != null) {
                        if (UtilHelper.isCurrentAccount(ab.this.ajX.bfy().getUserId())) {
                            ab.this.cfr();
                        } else {
                            ab.this.vV(1);
                        }
                    }
                } else if (i == 2) {
                    ab.this.cfs();
                } else if (i == 3) {
                    ab.this.cft();
                } else if (i == 4) {
                    ab.this.aB(ab.this.htf, true);
                } else if (i == 5) {
                    ab.this.cfu();
                } else if (i == 6) {
                    ab.this.cfw();
                } else if (i == 7) {
                    ab.this.cfv();
                } else if (i == 8) {
                    ab.this.cfx();
                }
                ab.this.vW(i);
            }
        };
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.hte = new ArrayList();
        this.htb = new com.baidu.tbadk.core.dialog.k(this.mContext);
        this.htb.setTitleText(getString(R.string.thread_manager, new Object[0]));
        this.htb.a(this.htj);
        this.hrC = new ForumManageModel(this.mPageContext);
        this.hrC.setLoadDataCallBack(this.hrJ);
        this.ewm = z;
        a(this.htb);
    }

    public void onChangeSkinType() {
        if (this.htb != null) {
            this.htb.onChangeSkinType();
        }
        if (this.hru != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.hru.getRealView());
        }
        if (this.htc != null) {
            com.baidu.tbadk.r.a.a(this.mPageContext, this.htc.getRealView());
        }
    }

    private void createView() {
        if (this.ajX != null && this.hte != null && this.htb != null) {
            this.hte.clear();
            if (!com.baidu.tieba.frs.j.coR()) {
                if (!this.ajX.isBjh()) {
                    this.hte.add(new com.baidu.tbadk.core.dialog.g(1, getString(R.string.delete_page, new Object[0]), this.htb));
                }
                String str = "";
                if (this.ajX.bfy() != null) {
                    str = this.ajX.bfy().getUserId();
                }
                if (!UtilHelper.isCurrentAccount(str)) {
                    this.hte.add(new com.baidu.tbadk.core.dialog.g(2, getString(R.string.thread_forbid, new Object[0]), this.htb));
                }
            }
            if (com.baidu.tieba.frs.j.coQ() || com.baidu.tieba.frs.j.coR()) {
                this.hte.add(new com.baidu.tbadk.core.dialog.g(3, getString(this.ajX.bft() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.htb));
                this.hte.add(new com.baidu.tbadk.core.dialog.g(4, getString(this.ajX.bfu() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.htb));
            }
            if (com.baidu.tieba.frs.j.coQ()) {
                this.hte.add(new com.baidu.tbadk.core.dialog.g(6, getString(R.string.frs_recommend_thread, new Object[0]), this.htb));
            }
            if (com.baidu.tieba.frs.j.coQ() && this.ewm) {
                this.hte.add(new com.baidu.tbadk.core.dialog.g(7, getString(R.string.frs_move_area_thread, new Object[0]), this.htb));
            }
            if (com.baidu.tieba.frs.j.coQ() || com.baidu.tieba.frs.j.coR()) {
                this.hte.add(new com.baidu.tbadk.core.dialog.g(8, getString(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.htb));
            }
            if (!com.baidu.tieba.frs.j.coR() && com.baidu.tieba.frs.b.cog().coi() && this.ewm) {
                this.hte.add(new com.baidu.tbadk.core.dialog.g(5, getString(R.string.multi_delete, new Object[0]), this.htb));
            }
            this.htb.aX(this.hte);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getString(int i, Object... objArr) {
        if (this.mContext == null) {
            return null;
        }
        return this.mContext.getString(i, objArr);
    }

    public void setData(bw bwVar) {
        this.ajX = bwVar;
        createView();
    }

    public void cfp() {
        if (this.hru != null && this.hru.isShowing()) {
            this.hru.dismiss();
        }
    }

    public void cfq() {
        if (this.htd != null && this.htd.isShowing()) {
            this.htd.dismiss();
        }
    }

    public void cfr() {
        cfp();
        if (this.mPageContext != null) {
            if (this.hru == null) {
                this.hru = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hru.nE(R.string.del_thread_confirm);
                this.hru.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.card.ab.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                        if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                        } else {
                            ab.this.X(null);
                        }
                    }
                });
                this.hru.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.card.ab.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (aVar != null) {
                            aVar.dismiss();
                        }
                    }
                });
                this.hru.id(true);
                this.hru.b(this.mPageContext);
            }
            this.hru.bia();
        }
    }

    public void vV(int i) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null) {
            com.baidu.tieba.NEGFeedBack.e eVar = new com.baidu.tieba.NEGFeedBack.e(this.mPageContext, this.mPageContext.getPageActivity().getWindow().getDecorView());
            AntiData coh = com.baidu.tieba.frs.b.cog().coh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (coh != null && coh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = coh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cod = com.baidu.tieba.frs.b.cog().cod();
            for (int i3 = 0; i3 < cod.size(); i3++) {
                jSONArray.put(cod.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.ne(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cog().getForumId());
            eVar.setData(arVar);
            eVar.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            eVar.DC("1");
            eVar.a(new e.b() { // from class: com.baidu.tieba.card.ab.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray2) {
                    if (!com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                        com.baidu.adp.lib.util.l.showToast(ab.this.mContext, R.string.neterror);
                    } else {
                        ab.this.X(jSONArray2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(ArrayList<aj> arrayList) {
        if (this.htd == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.commit_good, (ViewGroup) null);
            this.htd = new Dialog(this.mContext, R.style.common_alert_dialog);
            this.htd.setCanceledOnTouchOutside(true);
            this.htd.setCancelable(true);
            this.htd.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.htd.getWindow().getAttributes();
            attributes.width = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds540);
            this.htd.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.htd, ab.this.mPageContext);
                }
            });
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.ab.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.f.g.b(ab.this.htd, ab.this.mPageContext);
                    ab.this.aB(ab.this.htg, false);
                }
            });
        }
        com.baidu.tbadk.r.a.a(this.mPageContext, this.htd.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.htd.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.hth = new ArrayList();
        BlueCheckRadioButton es = es(this.htf, getString(R.string.thread_good_class, new Object[0]));
        es.setChecked(true);
        linearLayout.addView(es);
        this.hth.add(es);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                aj ajVar = arrayList.get(i);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bdM()) && ajVar.bdN() > 0) {
                    BlueCheckRadioButton es2 = es(String.valueOf(ajVar.bdN()), ajVar.bdM());
                    this.hth.add(es2);
                    View view = new View(this.mContext);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(es2);
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                }
            }
            ScrollView scrollView = (ScrollView) this.htd.findViewById(R.id.good_scroll);
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 120.0f);
                    break;
                case 2:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 186.0f);
                    break;
                default:
                    layoutParams.height = com.baidu.adp.lib.util.l.dip2px(this.mContext, 220.0f);
                    break;
            }
            scrollView.setLayoutParams(layoutParams);
            scrollView.removeAllViews();
            scrollView.addView(linearLayout);
        }
        com.baidu.adp.lib.f.g.a(this.htd, this.mPageContext);
    }

    private BlueCheckRadioButton es(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.mContext);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.hti);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        boolean z = true;
        if (this.ajX != null && gVar != null && gVar.Qx) {
            String str = "";
            if (i == 2) {
                this.ajX.nu(1);
                com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                xVar.type = 2;
                xVar.tid = this.ajX.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar));
            } else if (i == 3) {
                this.ajX.nu(0);
                str = aI(gVar.mro, R.string.operation_success);
                z = false;
            } else if (i == 4) {
                this.ajX.nt(1);
                com.baidu.tbadk.core.data.x xVar2 = new com.baidu.tbadk.core.data.x();
                xVar2.type = 1;
                xVar2.tid = this.ajX.getTid();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, xVar2));
            } else if (i == 5) {
                this.ajX.nt(0);
                str = aI(gVar.mro, R.string.operation_success);
                z = false;
            } else {
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.threadId = this.ajX.getId();
            eVar.forumName = this.ajX.bfC();
            eVar.forumId = String.valueOf(this.ajX.getFid());
            eVar.mrp = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_MANAGE, eVar));
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.operation_success, new Object[0]);
            }
            if (!z) {
                com.baidu.adp.lib.util.l.showToast(this.mContext, str);
                return;
            }
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.mro)) {
            string = gVar.mro;
        } else {
            string = getString(R.string.operation_failed, new Object[0]);
        }
        com.baidu.adp.lib.util.l.showToast(this.mContext, string);
    }

    private String aI(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return getString(i, new Object[0]);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW(int i) {
        if (this.ajX != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).ai("obj_type", i).u("uid", TbadkCoreApplication.getCurrentAccountId()).u("fid", this.ajX.getFid()).dF("tid", this.ajX.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfs() {
        if (this.mContext != null && this.ajX != null && this.ajX.bfy() != null) {
            String userId = this.ajX.bfy().getUserId();
            String userName = this.ajX.bfy().getUserName();
            String name_show = this.ajX.bfy().getName_show();
            String id = this.ajX.getId();
            String bfC = this.ajX.bfC();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(this.mContext, String.valueOf(this.ajX.getFid()), bfC, id, userId, userName, name_show, null, this.ajX.bfy().getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(JSONArray jSONArray) {
        if (this.hrC != null && this.ajX != null && this.ajX.bfy() != null) {
            String userId = this.ajX.bfy().getUserId();
            String id = this.ajX.getId();
            String bfC = this.ajX.bfC();
            String valueOf = String.valueOf(this.ajX.getFid());
            boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
            if (jSONArray != null) {
                this.hrC.Rp(at.R(jSONArray));
            }
            this.hrC.a(valueOf, bfC, id, null, 0, 1, isCurrentAccount, this.ajX.getBaijiahaoData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(String str, boolean z) {
        int i;
        if (this.ajX != null && this.hrC != null) {
            if (this.ajX.bfu() == 1) {
                i = 3;
            } else if (z) {
                i = 6;
            } else {
                i = 2;
            }
            String id = this.ajX.getId();
            String bfC = this.ajX.bfC();
            this.hrC.b(String.valueOf(this.ajX.getFid()), bfC, id, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cft() {
        int i;
        if (this.ajX != null && this.hrC != null) {
            if (this.ajX.bft() == 1) {
                i = 5;
            } else {
                i = 4;
            }
            String id = this.ajX.getId();
            String bfC = this.ajX.bfC();
            this.hrC.b(String.valueOf(this.ajX.getFid()), bfC, id, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfu() {
        com.baidu.tieba.frs.b.cog().T(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfv() {
        com.baidu.tieba.frs.a.cnZ().T(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfw() {
        if (this.mPageContext != null && this.ajX != null) {
            BawuThrones col = com.baidu.tieba.frs.c.cok().col();
            if (col == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (col.total_recommend_num.intValue() == col.used_recommend_num.intValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
            } else if (com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_frs_recommend_tip", true)) {
                com.baidu.tieba.frs.c.cok().b(this.mPageContext, String.valueOf(this.ajX.getFid()), this.ajX.getId());
            } else {
                com.baidu.tieba.frs.c.cok().eG(String.valueOf(this.ajX.getFid()), this.ajX.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.ajX));
    }

    public void dismissAllDialog() {
        cfp();
        cfq();
        dismiss();
    }

    public void destory() {
        dismissAllDialog();
    }
}
