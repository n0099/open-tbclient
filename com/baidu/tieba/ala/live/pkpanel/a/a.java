package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private TextView gRE;
    private RecyclerView gRF;
    private JSONObject gRG;
    private com.baidu.tieba.ala.live.pkpanel.b.a gRH;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.gRG = jSONObject;
        this.mOrientation = i;
        parseData(this.gRG);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.gRE = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.gRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.gRF = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.gRF.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.gRH != null) {
            this.title.setText(this.gRH.mTitle);
            bVar.setData(this.gRH.gxz);
        }
        this.gRF.setAdapter(bVar);
    }

    public void PA() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        vy(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.gRH == null) {
            this.gRH = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.gRH.parseData(jSONObject);
    }

    private void vy(int i) {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (i == 1) {
                attributes.height = -2;
                attributes.width = -2;
            } else {
                attributes.width = -2;
                attributes.height = c(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int c(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public boolean isShowing() {
        return this.mDialog != null && this.mDialog.isShowing();
    }

    public void hide() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public void vz(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            PA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gxz;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gxz = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0664a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gxz != null) {
                if ((viewHolder instanceof c) && this.gxz.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gxz.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0664a) {
                    ((C0664a) viewHolder).a(a.this.gRH);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.gRH == null || a.this.gRH.gxz == null) {
                return 0;
            }
            return a.this.gRH.gxz.size() + 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return vA(i) ? 2 : 1;
        }

        private boolean vA(int i) {
            return (a.this.gRH == null || a.this.gRH.gxz == null || a.this.gRH.gxz.size() != i) ? false : true;
        }
    }

    /* loaded from: classes4.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView dZV;
        private TextView gRJ;
        private HeadImageView gRK;
        private TextView gRL;
        private com.baidu.tieba.ala.live.pkpanel.b.b gRM;

        public c(@NonNull View view) {
            super(view);
            this.gRK = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.dZV = (TextView) view.findViewById(a.f.gift_name);
            this.gRL = (TextView) view.findViewById(a.f.gift_type);
            this.gRJ = (TextView) view.findViewById(a.f.gift_describe);
            if (this.gRK != null) {
                this.gRK.setIsRound(true);
                this.gRK.setAutoChangeStyle(false);
                this.gRK.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.gRM = bVar;
            if (this.gRM != null && i < a.this.gRH.gxz.size()) {
                if (TextUtils.isEmpty(this.gRM.icon)) {
                    this.gRK.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.gRK.setUrl(this.gRM.icon);
                    l.a(this.gRK, this.gRM.icon, false, false);
                }
                this.dZV.setText(this.gRM.name);
                this.gRL.setText(this.gRM.type);
                this.gRL.setTextColor(Color.parseColor(this.gRM.gRO));
                this.gRJ.setText(this.gRM.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0664a extends RecyclerView.ViewHolder {
        TextView gRJ;
        TextView title;

        public C0664a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.gRJ = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.gRJ.setText(aVar.gRN);
            }
        }
    }
}
