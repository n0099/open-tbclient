package com.baidu.tieba.ala.liveroom.o;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private boolean asR;
    private String asS;
    private TextView fjh;
    private TextView fji;
    private TextView fjj;
    private View fjk;
    private View fjl;
    private PersonUserData fjm;
    private b fjn;
    private TextView mCancel;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0464a {
        void onConfirm();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bqh();

        void onCancel();

        void zj(String str);

        void zk(String str);

        void zl(String str);

        void zm(String str);

        void zn(String str);

        void zo(String str);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.fjh = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.fjk = findViewById(a.g.ala_person_forbid_this_divider);
        this.fji = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.fjl = findViewById(a.g.ala_person_forbid_this_divider);
        this.fjj = (TextView) findViewById(a.g.ala_person_admin);
        this.mCancel = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.fjh.setOnClickListener(this);
        this.fji.setOnClickListener(this);
        this.fjj.setOnClickListener(this);
        this.mCancel.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.fjn != null) {
            if (view == this.fjh) {
                if (this.fjm != null && this.fjm.user_info != null) {
                    if (bqb()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjm != null && a.this.fjm.user_info != null) {
                                    a.this.fjm.user_info.is_block = 0;
                                    a.this.fjn.zl(a.this.fjm.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjm.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjm != null && a.this.fjm.user_info != null) {
                                a.this.fjm.user_info.is_block = 1;
                                a.this.fjn.zj(a.this.fjm.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.fjm.user_info.getNameShow()));
                }
            } else if (view == this.fji) {
                if (this.fjm != null && this.fjm.user_info != null) {
                    if (bqa()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.3
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjm != null && a.this.fjm.user_info != null) {
                                    a.this.fjm.user_info.is_block = 0;
                                    a.this.fjn.zm(a.this.fjm.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.fjm.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.4
                        @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                        public void onConfirm() {
                            if (a.this.fjm != null && a.this.fjm.user_info != null) {
                                a.this.fjm.user_info.is_block = 2;
                                a.this.fjn.zk(a.this.fjm.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.fjm.user_info.getNameShow()));
                }
            } else if (view == this.fjj) {
                if (this.fjm != null && this.fjm.login_user_info != null) {
                    if (bqc()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.5
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjm != null && a.this.fjm.login_user_info != null) {
                                    a.this.fjm.login_user_info.is_live_admin = 1;
                                    a.this.fjn.zn(a.this.fjm.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.fjm.user_info.getNameShow()));
                    } else if (bqd()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.6
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjm != null && a.this.fjm.login_user_info != null) {
                                    a.this.fjm.login_user_info.is_live_admin = 0;
                                    a.this.fjn.zo(a.this.fjm.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.fjm.user_info.getNameShow()));
                    } else if (bqe()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0464a() { // from class: com.baidu.tieba.ala.liveroom.o.a.7
                            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0464a
                            public void onConfirm() {
                                if (a.this.fjm != null && a.this.fjm.login_user_info != null) {
                                    a.this.fjm.login_user_info.is_live_admin = 0;
                                    a.this.fjn.bqh();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.mCancel) {
                this.fjn.onCancel();
            }
        }
    }

    private void a(final InterfaceC0464a interfaceC0464a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0464a != null) {
                    interfaceC0464a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.fjm = personUserData;
        this.asR = z;
        this.asS = str;
        if (bqf() || bqg()) {
            qA(8);
            qB(8);
        } else if (bqa()) {
            qA(8);
            this.fji.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bqb()) {
            qA(0);
            this.fjh.setText(a.i.ala_person_relieve_forbidden_this);
            this.fji.setText(a.i.ala_person_forbid_forever);
        } else {
            qA(0);
            this.fjh.setText(a.i.ala_person_forbid_this);
            this.fji.setText(a.i.ala_person_forbid_forever);
        }
        if (bpZ()) {
            this.fjj.setVisibility(8);
            this.fjl.setVisibility(8);
        } else if (bqd()) {
            this.fjj.setText(a.i.ala_person_fire_admin);
        } else if (bqc()) {
            this.fjj.setText(a.i.ala_person_appoint_admin);
        } else if (bqf() && bqe()) {
            this.fjj.setText(a.i.ala_person_resign_admin);
        } else {
            this.fjj.setVisibility(8);
            this.fjl.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.fjn = bVar;
    }

    private boolean bpZ() {
        return (this.fjm == null || this.fjm.user_info == null || this.fjm.user_info.is_block <= 0) ? false : true;
    }

    private boolean bqa() {
        return (this.fjm == null || this.fjm.user_info == null || this.fjm.user_info.is_block != 2) ? false : true;
    }

    private boolean bqb() {
        return (this.fjm == null || this.fjm.user_info == null || this.fjm.user_info.is_block != 1) ? false : true;
    }

    private boolean bqc() {
        return this.fjm != null && this.fjm.user_info != null && this.asR && this.fjm.user_info.is_live_admin == 0;
    }

    private boolean bqd() {
        return this.fjm != null && this.fjm.user_info != null && this.asR && this.fjm.user_info.is_live_admin == 1;
    }

    private boolean bqe() {
        return (this.fjm == null || this.fjm.login_user_info == null || this.asR || this.fjm.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bqf() {
        return (this.fjm == null || this.fjm.user_info == null || TextUtils.isEmpty(this.asS) || !this.asS.equals(this.fjm.user_info.user_id)) ? false : true;
    }

    private boolean bqg() {
        return (this.fjm == null || this.fjm.user_info == null || this.fjm.user_info.is_live_admin != 1) ? false : true;
    }

    private void qA(int i) {
        this.fjh.setVisibility(i);
        this.fjk.setVisibility(i);
    }

    private void qB(int i) {
        this.fji.setVisibility(i);
        this.fjl.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
