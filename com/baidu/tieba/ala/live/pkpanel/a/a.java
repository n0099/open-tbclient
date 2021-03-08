package com.baidu.tieba.ala.live.pkpanel.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private TextView hoj;
    private RecyclerView hok;
    private JSONObject hol;
    private com.baidu.tieba.ala.live.pkpanel.b.a hom;
    private Context mContext;
    private Dialog mDialog;
    private int mOrientation;
    private View mRootView;
    private TextView title;

    public a(Context context, int i, JSONObject jSONObject) {
        this.mContext = context;
        this.hol = jSONObject;
        this.mOrientation = i;
        parseData(this.hol);
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_panel_rule, (ViewGroup) null);
        this.title = (TextView) this.mRootView.findViewById(a.f.ala_title);
        this.hoj = (TextView) this.mRootView.findViewById(a.f.ala_close);
        this.hoj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.pkpanel.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hide();
            }
        });
        this.hok = (RecyclerView) this.mRootView.findViewById(a.f.giftRecycle);
        this.hok.setLayoutManager(new LinearLayoutManager(this.mContext));
        b bVar = new b(this.mContext);
        if (this.hom != null) {
            this.title.setText(this.hom.mTitle);
            bVar.setData(this.hom.gRY);
        }
        this.hok.setAdapter(bVar);
    }

    public void QH() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.RuleDialog);
            this.mDialog.setContentView(this.mRootView);
        }
        uW(this.mOrientation);
        if (!isShowing()) {
            this.mDialog.show();
        }
    }

    public void parseData(JSONObject jSONObject) {
        if (this.hom == null) {
            this.hom = new com.baidu.tieba.ala.live.pkpanel.b.a();
        }
        this.hom.parseData(jSONObject);
    }

    private void uW(int i) {
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
                attributes.height = d(274.0f, this.mDialog.getContext());
            }
            window.setAttributes(attributes);
        }
    }

    private int d(float f, Context context) {
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

    public void uX(int i) {
        this.mOrientation = i;
        if (isShowing()) {
            hide();
            QH();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<com.baidu.tieba.ala.live.pkpanel.b.b> gRY;
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public void setData(List<com.baidu.tieba.ala.live.pkpanel.b.b> list) {
            this.gRY = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            switch (i) {
                case 1:
                    return new c(LayoutInflater.from(this.mContext).inflate(a.g.ala_rule_content_item, viewGroup, false));
                case 2:
                    return new C0659a(LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_foot_rule, viewGroup, false));
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (this.gRY != null) {
                if ((viewHolder instanceof c) && this.gRY.size() > 0) {
                    com.baidu.tieba.ala.live.pkpanel.b.b bVar = this.gRY.get(i);
                    if (bVar != null) {
                        ((c) viewHolder).a(bVar, i);
                    }
                } else if (viewHolder instanceof C0659a) {
                    ((C0659a) viewHolder).a(a.this.hom);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.hom == null || a.this.hom.gRY == null) {
                return 0;
            }
            return a.this.hom.gRY.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return uY(i) ? 2 : 1;
        }

        private boolean uY(int i) {
            return (a.this.hom == null || a.this.hom.gRY == null || a.this.hom.gRY.size() != i) ? false : true;
        }
    }

    /* loaded from: classes10.dex */
    class c extends RecyclerView.ViewHolder {
        private TextView eoT;
        private TextView hoo;
        private HeadImageView hop;
        private TextView hoq;
        private com.baidu.tieba.ala.live.pkpanel.b.b hor;

        public c(@NonNull View view) {
            super(view);
            this.hop = (HeadImageView) view.findViewById(a.f.gift_icon);
            this.eoT = (TextView) view.findViewById(a.f.gift_name);
            this.hoq = (TextView) view.findViewById(a.f.gift_type);
            this.hoo = (TextView) view.findViewById(a.f.gift_describe);
            if (this.hop != null) {
                this.hop.setIsRound(true);
                this.hop.setAutoChangeStyle(false);
                this.hop.setDefaultResource(a.e.sdk_default_avatar);
            }
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.b bVar, int i) {
            this.hor = bVar;
            if (this.hor != null && i < a.this.hom.gRY.size()) {
                if (TextUtils.isEmpty(this.hor.icon)) {
                    this.hop.setDefaultResource(a.e.sdk_default_avatar);
                } else {
                    this.hop.setUrl(this.hor.icon);
                    m.a(this.hop, this.hor.icon, false, false);
                }
                this.eoT.setText(this.hor.name);
                this.hoq.setText(this.hor.type);
                this.hoq.setTextColor(Color.parseColor(this.hor.hou));
                this.hoo.setText(this.hor.content);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.live.pkpanel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C0659a extends RecyclerView.ViewHolder {
        TextView hoo;
        TextView title;

        public C0659a(@NonNull View view) {
            super(view);
            this.title = (TextView) view.findViewById(a.f.ala_title);
            this.hoo = (TextView) view.findViewById(a.f.ala_content);
        }

        public void a(com.baidu.tieba.ala.live.pkpanel.b.a aVar) {
            if (aVar != null) {
                this.title.setText(aVar.activityName);
                this.hoo.setText(aVar.hos);
            }
        }
    }
}
