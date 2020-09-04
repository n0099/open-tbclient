package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c extends m {
    private EditText eMK;

    public c(Context context) {
        super(context, (String) null, 29);
        this.eLw = false;
        this.eLv = 3;
        this.eKB = new TopicDetaiInputContainer(context);
        this.eMK = ((TopicDetaiInputContainer) this.eKB).getInputView();
        ((TopicDetaiInputContainer) this.eKB).setHint(context.getString(R.string.say_your_point));
        this.eLx = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.eMK;
    }
}
