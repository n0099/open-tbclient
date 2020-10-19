package com.baidu.tieba.ala.liveroom.s;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aEr;
    private boolean bhU;
    private TextView dQH;
    private TextView hac;
    private TextView had;
    private TextView hae;
    private View haf;
    private View hag;
    private PersonUserData hah;
    private b hai;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0653a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void HA(String str);

        void HB(String str);

        void HC(String str);

        void HD(String str);

        void HE(String str);

        void HF(String str);

        void cbr();

        void onCancel();
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
        this.hac = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.haf = findViewById(a.g.ala_person_forbid_this_divider);
        this.had = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.hag = findViewById(a.g.ala_person_forbid_this_divider);
        this.hae = (TextView) findViewById(a.g.ala_person_admin);
        this.dQH = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.hac.setOnClickListener(this);
        this.had.setOnClickListener(this);
        this.hae.setOnClickListener(this);
        this.dQH.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hai != null) {
            if (view == this.hac) {
                if (this.hah != null && this.hah.user_info != null) {
                    if (cbl()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                            public void onConfirm() {
                                if (a.this.hah != null && a.this.hah.user_info != null) {
                                    a.this.hah.user_info.is_block = 0;
                                    a.this.hai.HC(a.this.hah.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.hah.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                        public void onConfirm() {
                            if (a.this.hah != null && a.this.hah.user_info != null) {
                                a.this.hah.user_info.is_block = 1;
                                a.this.hai.HA(a.this.hah.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.hah.user_info.getNameShow()));
                }
            } else if (view == this.had) {
                if (this.hah != null && this.hah.user_info != null) {
                    if (cbk()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                            public void onConfirm() {
                                if (a.this.hah != null && a.this.hah.user_info != null) {
                                    a.this.hah.user_info.is_block = 0;
                                    a.this.hai.HD(a.this.hah.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.hah.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.4
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                        public void onConfirm() {
                            if (a.this.hah != null && a.this.hah.user_info != null) {
                                a.this.hah.user_info.is_block = 2;
                                a.this.hai.HB(a.this.hah.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.hah.user_info.getNameShow()));
                }
            } else if (view == this.hae) {
                if (this.hah != null && this.hah.login_user_info != null) {
                    if (cbm()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.5
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                            public void onConfirm() {
                                if (a.this.hah != null && a.this.hah.login_user_info != null) {
                                    a.this.hah.login_user_info.is_live_admin = 1;
                                    a.this.hai.HE(a.this.hah.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.hah.user_info.getNameShow()));
                    } else if (cbn()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.6
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                            public void onConfirm() {
                                if (a.this.hah != null && a.this.hah.login_user_info != null) {
                                    a.this.hah.login_user_info.is_live_admin = 0;
                                    a.this.hai.HF(a.this.hah.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.hah.user_info.getNameShow()));
                    } else if (cbo()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0653a() { // from class: com.baidu.tieba.ala.liveroom.s.a.7
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0653a
                            public void onConfirm() {
                                if (a.this.hah != null && a.this.hah.login_user_info != null) {
                                    a.this.hah.login_user_info.is_live_admin = 0;
                                    a.this.hai.cbr();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dQH) {
                this.hai.onCancel();
            }
        }
    }

    private void a(final InterfaceC0653a interfaceC0653a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0653a != null) {
                    interfaceC0653a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.9
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
        this.hah = personUserData;
        this.bhU = z;
        this.aEr = str;
        if (cbp() || cbq()) {
            vC(8);
            vD(8);
        } else if (cbk()) {
            vC(8);
            this.had.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (cbl()) {
            vC(0);
            this.hac.setText(a.i.ala_person_relieve_forbidden_this);
            this.had.setText(a.i.ala_person_forbid_forever);
        } else {
            vC(0);
            this.hac.setText(a.i.ala_person_forbid_this);
            this.had.setText(a.i.ala_person_forbid_forever);
        }
        if (cbj()) {
            this.hae.setVisibility(8);
            this.hag.setVisibility(8);
        } else if (cbn()) {
            this.hae.setText(a.i.ala_person_fire_admin);
        } else if (cbm()) {
            this.hae.setText(a.i.ala_person_appoint_admin);
        } else if (cbp() && cbo()) {
            this.hae.setText(a.i.ala_person_resign_admin);
        } else {
            this.hae.setVisibility(8);
            this.hag.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hai = bVar;
    }

    private boolean cbj() {
        return (this.hah == null || this.hah.user_info == null || this.hah.user_info.is_block <= 0) ? false : true;
    }

    private boolean cbk() {
        return (this.hah == null || this.hah.user_info == null || this.hah.user_info.is_block != 2) ? false : true;
    }

    private boolean cbl() {
        return (this.hah == null || this.hah.user_info == null || this.hah.user_info.is_block != 1) ? false : true;
    }

    private boolean cbm() {
        return this.hah != null && this.hah.user_info != null && this.bhU && this.hah.user_info.is_live_admin == 0;
    }

    private boolean cbn() {
        return this.hah != null && this.hah.user_info != null && this.bhU && this.hah.user_info.is_live_admin == 1;
    }

    private boolean cbo() {
        return (this.hah == null || this.hah.login_user_info == null || this.bhU || this.hah.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cbp() {
        return (this.hah == null || this.hah.user_info == null || TextUtils.isEmpty(this.aEr) || !this.aEr.equals(this.hah.user_info.user_id)) ? false : true;
    }

    private boolean cbq() {
        return (this.hah == null || this.hah.user_info == null || this.hah.user_info.is_live_admin != 1) ? false : true;
    }

    private void vC(int i) {
        this.hac.setVisibility(i);
        this.haf.setVisibility(i);
    }

    private void vD(int i) {
        this.had.setVisibility(i);
        this.hag.setVisibility(i);
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
