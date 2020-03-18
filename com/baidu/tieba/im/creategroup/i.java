package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class i implements o {
    CreateGroupStepActivity hxC;
    private int hxG;
    HeadImageView hyc;
    ImageView hyd;
    TextView hye;
    private com.baidu.adp.widget.ImageView.a hyf = null;
    private a hyg = null;
    private int mIndex;
    private int mStep;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.hxC = null;
        this.mView = null;
        this.hyc = null;
        this.hyd = null;
        this.hye = null;
        this.hxC = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.hyd = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.hyc = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.hye = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.hxG = i3;
    }

    public void bTB() {
        if (this.hyg != null) {
            this.hyg.cancel();
        }
        this.hyf = null;
        this.hyg = new a();
        this.hyg.execute(new Object[0]);
    }

    public ImageView bTC() {
        return this.hyd;
    }

    public TextView bTD() {
        return this.hye;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTl() {
        this.hyd.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void bTm() {
        this.hxC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxC.getLayoutMode().onModeChanged(this.mView);
        this.hyc.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.hyc.setVisibility(0);
                i.this.hyf = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.hyf.drawImageTo(i.this.hyc);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.hxC.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String bTo() {
        if (this.mIndex != this.hxG) {
            return this.hxC.getPageContext().getString(R.string.next_step);
        }
        return this.hxC.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTp() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int bTf() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean bTq() {
        return true;
    }
}
